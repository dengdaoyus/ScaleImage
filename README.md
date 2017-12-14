# ScaleImage
大图加载，长图加载，仿新浪微博

# 效果图
![图片名称](https://github.com/dengdaoyus/ScaleImage/blob/master/gif/1513221665024.gif?raw=true)
![图片名称](https://github.com/dengdaoyus/ScaleImage/blob/master/gif/1513221730779.gif?raw=true)

```java
## 动画显示大图：
float maxScale = imageView.getMaxScale();
PointF center = new PointF(imageView.getSWidth(), 0);                  
RxScaleImageView.AnimationBuilder animationBuilder = imageView.animateScaleAndCenter(maxScale, center);                   
animationBuilder.withDuration(1000).withEasing(RxScaleImageView.EASE_OUT_QUAD).withInterruptible(false).start();


## 动画显示大图：
float maxScale = imageView.getMaxScale();
PointF center = new PointF(imageView.getSWidth(), 0);
                    imageView.setScaleAndCenter(maxScale, center);
```

# 注意：
//将默认放大的图片在顶端，只需要设置修改
PointF center = new PointF(imageView.getSWidth(), 0); 

