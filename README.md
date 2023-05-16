# BeerPaging3Project

An Android application showcasing a list of beers

### Technologies
- **UI** - [Jetpack Compose](https://developer.android.com/jetpack/compose) ([Material3](https://m3.material.io/))
- **DI** - [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Architecture pattern** - [MVVM](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel)
- **Local database** - [Room](https://developer.android.com/training/data-storage/room)
- **Networking** - [Retrofit2](https://square.github.io/retrofit/)
- **Image Loading** - [Coil-Compose](https://coil-kt.github.io/coil/compose/)
- **Pagination** - [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)

### About Paging3
The [Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) library, a part of [Android Jetpack](https://developer.android.com/jetpack), provides efficient data loading in "pages" for large datasets. It optimizes resource usage and improves UX by loading data asynchronously. With support for different data sources, it features in-memory caching, deduplication, RecyclerView adapters, and compatibility with Kotlin coroutines, LiveData, and RxJava.

Paging3 integrates seamlessly with Room and Jetpack Compose. With Room, it can directly load paginated data from a database, reducing additional data-handling code. Complementing Jetpack Compose's declarative UI, Paging3 works efficiently with async loading. Compose's ```LazyColumn``` and ```collectAsLazyPagingItems``` align with Paging3's data streams, facilitating efficient data display. The library offers flexibility for any network stack or database, and manages complex scenarios such as loading placeholders and retrying failed data loads.

### Screenshots
<img src="https://github.com/EvgenyPlaksin/BeerPaging3Project/assets/94696816/820c7d0d-329b-4504-8d1e-8d2086dda01e.png" width="200" height="400" />
<img src="https://github.com/EvgenyPlaksin/BeerPaging3Project/assets/94696816/60b07f73-cb49-47d8-94a6-cc6434318086.png" width="200" height="400" />
