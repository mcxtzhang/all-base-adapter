# all-base-adapter
[![](https://jitpack.io/v/mcxtzhang/all-base-adapter.svg)](https://jitpack.io/#mcxtzhang/all-base-adapter)

## Adapter 终结者
**Adapter终结者，包含DataBinding，任意ViewGroup，Rv、Lv列表。写Adapter，有它就够了**

Some base Adapters apply to any ViewGroup. Such as LinearLayout, ScrollView, and custom ViewGroups. Of course, including RecyclerView, ListView ..

一些Base Adapter,适用于任意ViewGroup。像LinearLayout，ScrollView以及自定义的ViewGroup。当然也包括RecyclerView，ListView。

现在也加入了**DataBinding**用的BaseAdapter。

Related posts:

相关博文：
[ViewGroup 篇 封装博文]

[DataBinding 篇 封装博文]


If you like, point a star .Thank you very much!

喜欢随手点个star 多谢 


## The ultimate goal:
## 最终的目标:
To meet all the development needs of needs adapter for ViewGroup

满足开发中所有需要adapter需求的ViewGroup。

## Where to find me:
##  在哪里找到我：

My github:

我的github：

https://github.com/mcxtzhang

My CSDN Blog:

我的CSDN博客：

http://blog.csdn.net/zxt0601

My xitu.io:

我的稀土掘金：

http://gold.xitu.io/user/56de210b816dfa0052e66495

My jianshu:

我的简书：

http://www.jianshu.com/users/8e91ff99b072/timeline
***


# 效果一览：

![APP首页常见](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/DataBinding/multypemulbean.gif)

![多种Item，数据结构相同。](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/multype1.gif)

![这次用横向展示 多种Item，数据结构不同。](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/multype2.gif)

![文首提到的，一开始是个水平ScrollView](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/nochange.gif)

![替换成流式布局](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/FlowSwipe.gif)


# 使用：
Step 1. Add the JitPack repository to your build file

Step 1. 在项目根build.gradle文件中增加JitPack仓库依赖。
```
    allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
Step 2. Add the dependency
```
    dependencies {
	        compile 'com.github.mcxtzhang:all-base-adapter:V1.7.1'
	}
```


Step 3.

[DataBinding相关点这里](https://github.com/mcxtzhang/all-base-adapter/blob/master/README-cn-DataBinding.md)


[（推荐）ViewGroup V1.5.0版本之后 相关点这里](https://github.com/mcxtzhang/all-base-adapter/blob/master/README-cn-ViewGroup_after_1.5.0.md)

[（不推荐）ViewGroup V1.5.0版本之前 相关点这里](https://github.com/mcxtzhang/all-base-adapter/blob/master/README-cn-ViewGroup.md)


## About
![ViewGroup](https://github.com/mcxtzhang/all-base-adapter/blob/master/gif/AllBaseAdapter.png)


## to do list
* ~~考虑加入复用缓存池~~
* ~~考虑替换`onBindView()`的`ItemView`->`通用的ViewHolder`，这样可以少写一些`findViewById()`代码~~
* ~~整合DataBinding 的通用Adapter入库。~~
* 整合 RecyclerView、ListView的通用Adapter入库。
* 加入一些自定义ViewGroup入库，例如流式布局，九宫格，Banner轮播图。

## Update：
Version [V1.7.0]
Created [2017 04 23]
1 Add `notifyDatasetChanged()` for `Adapter`,which uses to refresh ViewGroup's UI .(More convenient update views).

Version [V1.6.0]
Created [2017 04 21]
1 fix a bug for adding header and multi type for RecyclerView.

Version [V1.5.2]
Created [2017 01 13]
1 Add a VGUtil which add views for any viewgroup.(More convenient update views for any viewgroup than ViewGroupUtils).

版本 [V1.5.0]
日期 [2016 12 30]
1 加入复用缓存池，目前默认是缓存5个。类似于RecyclerViewPool。
2 替换`onBindView()`的`ItemView`->`通用的ViewHolder`，这样可以少写一些`findViewById()`代码~
3 加入了一些自定义ViewGroup：流式布局。 和一个 用于嵌套的FakerGridView，具体情况可见Demo。

2016 12 13 V1.1.0:
* 加入DataBinding的BaseAdapter
* 加入RecyclerView、ListView BaseAdapter初版。

[ViewGroup 篇 封装博文]:https://gold.xitu.io/post/584d52fdb123db00661c59fa
[DataBinding 篇 封装博文]:https://gold.xitu.io/post/584fbdbe128fe1006c988d55
