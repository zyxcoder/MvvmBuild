[![][![](https://www.jitpack.io/v/zyxcoder/MvvmBuild.svg)](https://www.jitpack.io/#zyxcoder/MvvmBuild)

### MvvmBuild
 MvvmBuild是一个帮助快速构建MVVM架构的插件
 
 
 **添加依赖**
 
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
        implementation 'com.github.zyxcoder:MvvmBuild:Tag'
}
```
#### 使用说明
1.在应用目录下的build.gradle下，配置如下代码(按需配置)
```
android {
    ...
   buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

还需引入两个库
dependencies {
        implementation 'com.squareup.okhttp3:logging-interceptor:4.7.2'
        implementation 'com.github.CymChad:BaseRecyclerViewAdapterHelper:3.0.10'
}

```
### 关于基类
```
1.Application 
  如果不想手写获取全局ViewModel的方法，可以继承BaseApp


2.Activity/Fragment
  这里需要选择性继承: 如果是开启的dataBinding模式，则需要继承BaseVmDbActivity/BaseVmDbFragment
                    如果是开启的viewBinding模式，则需要继承BaseVmVbActivity/BaseVmVbFragment
                    如果两者都没开启，那么继承BaseVmActivity/BaseVmFragment即可

3.Adapter
  这里只写了viewBinding模式的adapter，dataBinding模式类似，可以自己实现
  
```

### 网络请求(Retrofit+协程)
  为了有更好的扩展性，需要用户自己继承BaseNetworkApi实现，具体实现可参考demo
  ```
  class NetworkApi : BaseNetworkApi() {

    companion object {
        val INSTANCE: NetworkApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkApi()
        }
    }

    override fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder.apply {
            //示例：添加公共heads 注意要设置在日志拦截器之前，不然Log中会不显示head信息
            addInterceptor(MyHeadInterceptor())
                // 日志拦截器
                .addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                    override fun log(message: String) {
                        Log.d("HttpLoggingInterceptor", message)
                    }
                }).apply {
                    level = if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                })
            //超时时间 连接、读、写
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
        }
    }

    override fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder =
        builder.addConverterFactory(GsonConverterFactory.create())
}
  ```

### 常用工具类(目前比较少，后续将不断加入)

  



          
