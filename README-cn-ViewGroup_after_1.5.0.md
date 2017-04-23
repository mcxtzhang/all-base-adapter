## ViewGroup 篇：
适用于任意ViewGroup。像LinearLayout，ScrollView以及自定义的ViewGroup(流式布局、九宫格balabala)。

相关博文：

https://gold.xitu.io/post/584d52fdb123db00661c59fa


### 1 单Item列表
#### 效果如图：

![margin等属性都是正常显示的](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/single.png)

#### 用法：

Adapter泛型传入JavaBean，构造函数传入数据集和layout布局，**一句代码**搞定：
```
        final SingleAdapter adapter1 = new SingleAdapter<K50Bean>(this, mDatas, R.layout.item_50k) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, K50Bean data, int pos) {
                holder.setText(R.id.tv, data.getName());
            }
        };

        //单一ItemView
        ViewGroupUtils.addViews(llCurrent, adapter1);

```



### 2 多Item、同种数据类型列表
#### 效果如图：

![多种Item，数据结构相同。](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/multype1.gif)

#### 用法：

数据结构相同依然可以给Adapter传入泛型，避免强转：
```
        //设置OnItemClickListener
        OnItemClickListener onItemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(MulTypeActivity.this, "通过OnItemClickListener设置:" + position, Toast.LENGTH_SHORT).show();
            }
        };

        //多种ItemViewType，但是数据结构相同，可以传入数据结构泛型，避免强转
        ViewGroupUtils.addViews(linearLayout, new MulTypeAdapter<MulTypeBean>(this, initDatas()) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, final MulTypeBean data, int pos) {
                holder.setText(R.id.tvWords, data.getName() + "");
                Glide.with(MulTypeActivity.this)
                        .load(data.getAvatar())
                        .into((ImageView) holder.findViewById(ivAvatar));
                //#### Adapter.onBindView()里设置 优先级更高
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "onBindView里设置:文字是:" + data.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

        }, onItemClickListener);
        //可以在`ViewGroupUtils.addViews`直接作为参数传入.\
        // 也可以用`ViewGroupUtils.setOnItemClickListener(）`设置
        // **优先级比`Adapter.onBindView()`里设置低，**
        //ViewGroupUtils.setOnItemClickListener(linearLayout,onItemClickListener);
```


### 3 多Item、多种数据类型列表
#### 效果如图：

![这次用横向展示 多种Item，数据结构不同。](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/multype2.gif)


#### 用法：
如果数据结构不同，则不用传入泛型，但是使用时需要强转：
```
        //多种Item类型：数据结构不同 不传泛型了 使用时需要强转javaBean，判断ItemLayoutId
        ViewGroupUtils.addViews((ViewGroup) findViewById(R.id.activity_mul_type_mul_bean), new MulTypeAdapter(this, datas) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, IMulTypeHelper data, int pos) {
                switch (data.getItemLayoutId()) {
                    case R.layout.item_mulbean_1:
                        MulBean1 mulBean1 = (MulBean1) data;
                        Glide.with(MulTypeMulBeanActivity.this)
                                .load(mulBean1.getUrl())
                                .into((ImageView) holder.itemView);
                        break;
                    case R.layout.item_mulbean_2:
                        MulBean2 mulBean2 = (MulBean2) data;
                        TextView tv = (TextView) holder.itemView;
                        tv.setText(mulBean2.getName());
                }
            }

        });
```
数据结构：
```
public class MulBean1 implements IMulTypeHelper {
    private String url;
    @Override
    public int getItemLayoutId() {
        return R.layout.item_mulbean_1;
    }
}
```

```
public class MulBean2 implements IMulTypeHelper {
    private String name;
    @Override
    public int getItemLayoutId() {
        return R.layout.item_mulbean_2;
    }
}
```

Item1布局是一个ImageView，Item2布局是一个TextView

### 4 Item点击事件
item的点击和长按等事件，有两种方法设置,这里以点击事件为例，长按事件同理：
#### 4.1 Adapter.onBindView()里设置
在`Adapter.onBindView()`方法里能拿到ItemView，自然就可以设置各种事件。类似RecyclerView。

**在这里设置优先级更高。原因后文会提到。**

```
@Override
            public void onBindView(ViewGroup parent, View itemView, final MulTypeBean data, int pos) {
                ....
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "onBindView里设置:文字是:" + data.getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
```
#### 4.2 通过ViewGroupUtils设置
可以在`ViewGroupUtils.addViews`直接作为参数传入.

也可以用`ViewGroupUtils.setOnItemClickListener(）`设置       。

**优先级比`Adapter.onBindView()`里设置低，原因后文会提到。**
```
        //设置OnItemClickListener
        OnItemClickListener onItemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(MulTypeActivity.this, "通过OnItemClickListener设置:" + position, Toast.LENGTH_SHORT).show();
            }
        };
        //可以在`ViewGroupUtils.addViews`直接作为参数传入.\
        ViewGroupUtils.addViews(linearLayout, adapter ,onItemClickListener);
        //或者 也可以用`ViewGroupUtils.setOnItemClickListener(）`设置
        ViewGroupUtils.setOnItemClickListener(linearLayout,onItemClickListener);

```

### 5 刷新方法
#### 5.1 API:
```
   Adapter.notifyDatasetChanged();
```
#### 5.2 用法：

```
        final SingleAdapter adapter1 = new SingleAdapter<K50Bean>(this, mDatas, R.layout.item_50k) {
            @Override
            public void onBindViewHolder(ViewGroup parent, ViewHolder holder, K50Bean data, int pos) {
                holder.setText(R.id.tv, data.getName());
            }
        };

        //单一ItemView
        //ViewGroupUtils.addViews(llCurrent, adapter1);
        final VGUtil vgUtil = new VGUtil(llCurrent, adapter1, new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View itemView, int position) {
                Toast.makeText(LinearLayoutActivity.this, "position：" + position + "被删除了", Toast.LENGTH_SHORT).show();
                mDatas.remove(position);
                adapter1.notifyDatasetChanged();
            }
        });
        vgUtil.bind();

```
