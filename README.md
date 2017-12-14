# ScaleImage
大图加载，长图加载，仿新浪微博

# 效果图


## 带动画显示大图：
```java
float maxScale = imageView.getMaxScale();
PointF center = new PointF(imageView.getSWidth(), 0);                  
RxScaleImageView.AnimationBuilder animationBuilder = imageView.animateScaleAndCenter(maxScale, center);                   
animationBuilder.withDuration(1000).withEasing(RxScaleImageView.EASE_OUT_QUAD).withInterruptible(false).start();>`
```
```java                    
## 默认显示大图：
 float maxScale = imageView.getMaxScale();
  PointF center = new PointF(imageView.getSWidth(), 0);
  imageView.setScaleAndCenter(maxScale, center);
  ```
