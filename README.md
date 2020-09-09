# FlickrApp
This is an Flickr gallery app  using Architecture Components (ViewModel, LiveData & RxJava)

## PRESENTATION
This simple app consists of  two screens
* PhotosFeed(Fetch (Retrofit) the flickr public photos)
* PhotoDetail(Show the detailed info when clicked on a photo from PhotosFeed)


## UI Testing and unit testing
* I have used roboelectric for UI testing as well as for view model tests.
* Unit tests involves dagger injection using test components.Please make sure that DaggerTestComponent is created(Building the project will generate dagger components).

### Architecture Components
This application implements the following concepts :
- ViewModel
- LiveData
- RxJava 2
- Dagger 2
- MockWebServer

### Libraries
* [Android Architecture Components][arch]
* [Dagger 2][dagger2] for dependency injection
* [RxJava 2][rxjava2] for composing asynchronous and event-based programs using observable sequences
* [Retrofit][retrofit] for REST api communication
* [Glide][glide] for image loading
* [MockWebServer][mockwebserver] for testing HTTP clients

## PREVIEW
![Alt Text](https://imgur.com/a/3xdZXOr.png)
![Alt Text](https://imgur.com/a/wDxxC9P.png)

