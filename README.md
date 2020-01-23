# Currency Application

Web application which shows latest currencies, gold price and convert any amount to another currency.
To use converter user has to have account.

### Installing

To open app in your own IDE clone this repository

```
git clone https://github.com/KamilaNowak/currency-app.git
```
And run Docker procedures to run the application
```
docker build -f Dockerfile -t <App name>:<version> .
```
Check what ID has created image and run the application
```
docker run -p 8000:8080 <Image ID>
```

## Built With

* [Spring Framework](https://spring.io/) - The web framework
* [Spring WebFlux](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html) - Spring Reactive library 
* [Hibernate](https://hibernate.org/) - Framework for managing data
* [Maven](https://maven.apache.org/) - Dependency Management
* [PostgreSQL](https://www.postgresql.org/) - Database
* [Bootstrap 4](https://getbootstrap.com/) - CSS framework
* [Thymeleaf](https://www.thymeleaf.org/) - Template engine for HTMLs
* [Heroku](https://dashboard.heroku.com/) - Server where app is deployed

## Used external APIs

* [exchangeratesapi.io](https://exchangeratesapi.io/)
* [frankfurter.app](https://www.frankfurter.app/docs/)
* [NBP WEB API](http://api.nbp.pl/) 

## Author

* **Kamila Nowak** - *Initial work* - [KamilaNowak](https://github.com/KamilaNowak)


## License

This project is licensed under the MIT License 

