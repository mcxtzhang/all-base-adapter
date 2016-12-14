## DataBinding 篇：


### 使用必读：
`BaseBindingAdapter`利用DataBinding提供的动态绑定技术,使用`BR.data`封装数据、`BR.itemP`封装点击事件。所以对`layout`有以下要求：
* layout中 数据name起名**data**
* layout中 点击事件Presenter起名 **itemP**

如：

```
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools">
    <data>
        <variable
            name="itemP"
            type="mcxtzhang.commonviewgroupadapter.databinding.rv.single.DBSingleActivity.SingleItemPresenter"/>
        <variable
            name="data"
            type="mcxtzhang.commonviewgroupadapter.databinding.rv.single.DBSingleBean"/>
    </data>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="1dp"
        android:background="@color/colorAccent"
        android:onClick="@{v->itemP.onItemClick(data)}"
        android:orientation="horizontal">
        <ImageView
            android:id="@+id/ivAvatar"
            android:layout_width="200dp"
            android:layout_height="200dp"
            app:netUrl="@{data.avatar}"
            tools:src="@mipmap/ic_launcher"/>
        <TextView
            android:id="@+id/tvName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{data.name}"
            tools:text="测试多种"/>
    </LinearLayout>
</layout>
```


### 1 单Item列表
#### 效果如图：

顺带演示了BaseBindingAdapter封装的一些增删功能。
![单Item](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/DataBinding/singitem.gif)

#### 用法：

和其他BaseAdapter用法一致:
* 构造函数只需要传入context，datas，layout


```
    mAdapter = new BaseBindingAdapter(this, mDatas, R.layout.item_db_single);
```
如果需要设置点击事件（点击事件设置所有类型都一样，下不赘述）：

```
    //★ 设置Item点击事件
    mAdapter.setItemPresenter(new SingleItemPresenter());
```

```
    /**
     * ★ Item点击事件P
     */
    public class SingleItemPresenter {
        public void onItemClick(DBSingleBean data) {
            data.setName("修改之后立刻见效");
        }
    }
```

#### 特殊需求：
如果有特殊需求，可传入两个泛型，重写onBindViewHolder搞事情：
```
        // ★泛型D:是Bean类型，如果有就传。  泛型B:是对应的xml Layout的Binding类
        mAdapter = new BaseBindingAdapter<DBSingleBean, ItemDbSingleBinding>(this, mDatas, R.layout.item_db_single) {
            @Override
            public void onBindViewHolder(BaseBindingVH<ItemDbSingleBinding> holder, int position) {
                //★super一定不要删除
                super.onBindViewHolder(holder, position);
                //如果有特殊需求，可传入两个泛型，重写onBindViewHolder搞事情。
                ItemDbSingleBinding binding = holder.getBinding();
                DBSingleBean data = mDatas.get(position);
            }
        };
```

### 2 多Item同种数据类型列表
一般是像IM那种列表，虽然Item不同，但是数据结构是同一个。用法，**一句话**~
#### 效果如图：

![多Item同数据结构](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/DataBinding/multypesinglebean.gif)

#### 用法：

* 数据结构（JavaBean）需实现`IBaseMulInterface`接口,根据情况返回不同的layout。
* 构造函数只需要传入context，datas.

```
    mAdapter = new BaseMulTypeBindingAdapter(this, mDatas);
```

```
/**
 * 介绍：多种type单数据结构Bean
 * 作者：zhangxutong
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2016/12/13.
 */

public class MulTypeSingleBean extends BaseObservable implements IBaseMulInterface {
    private String avatar;
    private String name;
    private boolean receive;
    @Override
    public int getItemLayoutId() {
        if (isReceive()) {
            return R.layout.item_db_mul_1;
        } else {
            return R.layout.item_db_mul_2;
        }
    }
}
```


#### 特殊需求：
如果有特殊需求，可传入数据结构的泛型，避免强转，重写`onBindViewHolder()`方法,但是Binding类 不可避免的需要强转了：
```
        mAdapter = new BaseMulTypeBindingAdapter<MulTypeSingleBean>(this, mDatas) {
            @Override
            public void onBindViewHolder(BaseBindingVH<ViewDataBinding> holder, int position) {
                super.onBindViewHolder(holder, position);
                //如果有特殊需求，可传入数据结构的泛型，避免强转
                MulTypeSingleBean data = mDatas.get(position);
                //Binding类 不可避免的需要强转了
                ViewDataBinding binding = holder.getBinding();
                switch (data.getItemLayoutId()) {
                    case R.layout.item_db_mul_1:
                        ItemDbMul1Binding itemDbMul1Binding = (ItemDbMul1Binding) binding;
                        break;
                    case R.layout.item_db_mul_2:
                        ItemDbMul2Binding itemDbMul2Binding = (ItemDbMul2Binding) binding;
                        break;
                }

            }
        };
```

### 3 多Item、多种数据类型列表
各大APP首页，Banner、列表、推荐混排，数据结构肯定不同，但是依然只要**一句代码**搞定Adapter！

#### 效果如图：

![多Item、多数据结构](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/DataBinding/multypemulbean.gif)


#### 用法：

* 数据结构（JavaBean）需**分别**实现`IBaseMulInterface`接口,返回数据结构对应的layout。
* 构造函数只需要传入context，datas.

```
    mAdapter = new BaseMulTypeBindingAdapter(this, mDatas);
```


```
public class MulTypeMulBean1 extends BaseObservable implements IBaseMulInterface {
    private String avatar;
    private String name;

    @Override
    public int getItemLayoutId() {
        return R.layout.item_db_mulbean_1;
    }
}
```

```
public class MulTypeMulBean2 extends BaseObservable implements IBaseMulInterface {
    private String background;

    @Override
    public int getItemLayoutId() {
        return R.layout.item_db_mulbean_2;
    }
}
```


#### 特殊需求：
如果有特殊需求，重写`onBindViewHolder()`方法,但是数据结构 和 Binding类 都不可避免的需要强转了：
```
        mAdapter = new BaseMulTypeBindingAdapter(this, mDatas) {
            @Override
            public void onBindViewHolder(BaseBindingVH holder, int position) {
                super.onBindViewHolder(holder, position);
                //如果有特殊需求 重写onBindViewHolder方法
                // 数据结构 和 Binding类 都不可避免的需要强转了
                ViewDataBinding binding = holder.getBinding();
                switch (getItemViewType(position)) {
                    case R.layout.item_db_mul_1:
                        ItemDbMul1Binding itemDbMul1Binding = (ItemDbMul1Binding) binding;
                        MulTypeMulBean1 data1 = (MulTypeMulBean1) mDatas.get(position);
                        break;
                    case R.layout.item_db_mul_2:
                        ItemDbMul2Binding itemDbMul2Binding = (ItemDbMul2Binding) binding;
                        MulTypeMulBean2 data2 = (MulTypeMulBean2) mDatas.get(position);
                        break;
                }
            }
        };
```

### 4 不能忘了上文的ViewGroup呀

对上文封装的ViewGroup类型Adapter也提供DataBinding的支持。

#### 效果如图：

当然还是流式布局搭配[史上集成最叼侧滑菜单控件]。

![](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/DataBinding/flowSwipe.gif)

#### 用法：

和上文[快速开发偷懒必备（一）]一样，只是Adapter换成`SingleBindingAdapter`

```
    mAdapter = new SingleBindingAdapter<>(this, mDatas = iniDatas(), R.layout.item_db_flow_swipe);
```
如果需要设置点击事件：

```
    mAdapter.setItemPresenter(new ItemDelPresenter());
```