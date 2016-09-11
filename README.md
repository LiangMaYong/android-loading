# android-loading
this is android loading dialog

Welcome Star and Issues

download jar : [android-loading-src.jar](https://raw.githubusercontent.com/LiangMaYong/android-loading/master/jar/android-loading-src.jar)

## Use this
1,showLoading
```
// no label
Loading.showLoading(this);

Loading.showLoading(this, "Loading");

Loading.showLoading(this, "开始加载数据");

//custom colors
Loading.setDimAmount(0.05f);
Loading.setLoadingColor(0xff3F51B5);
Loading.setBackgroundColor(0x30aaaaaa);

of

Loading.showLoading(this, "Loading", 0xff3F51B5, 0x30aaaaaa, 0.3f);

```
2,cancelLoading
```
 Loading.cancelLoading(MainActivity.this);
```

## Screenshot
![Screenshot](https://raw.githubusercontent.com/LiangMaYong/android-loading/master/screenshot.png)
![Screenshot](https://raw.githubusercontent.com/LiangMaYong/android-loading/master/screenshot_1.png)

##License
```
Copyright 2016 LiangMaYong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
