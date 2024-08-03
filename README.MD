# rmi-client

`rmi-client` — это проект-клиент, который взаимодействует с RMI сервером для выполнения операций над книгами. Проект предоставляет клиента, который отправляет запросы к RMI серверу и получает ответы.

## Содержание

- [Описание](#описание)
- [Установка](#установка)
- [Использование](#использование)
- [Публикация через JitPack](#публикация-через-jitpack)
  - [Шаг 1: Подготовьте проект](#шаг-1-подготовьте-проект)
  - [Шаг 2: Создайте файл GitHub репозитория](#шаг-2-создайте-файл-github-репозитория)
  - [Шаг 3: Сборка и публикация проекта](#шаг-3-сборка-и-публикация-проекта)
- [Примеры кода](#примеры-кода)
  - [RmiClient](#rmiclient)

## Описание

Этот клиент использует сгенерированные интерфейсы для взаимодействия с RMI сервером, предоставляющим методы для работы с книгами.

## Установка

Для установки и настройки проекта выполните следующие шаги:

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/Ваша_организация/Ваш_репозиторий.git
   cd Ваш_репозиторий
   ```

2. Убедитесь, что у вас установлена Java 21 и Maven.

3. Соберите проект:
   ```bash
   mvn clean install
   ```

## Использование

Для отправки RMI запросов к серверу выполните следующий код:

### Примеры кода

#### RmiClient

```java
package com.edu;

import com.edu.dto.BookRMI;
import com.edu.rmi.BookRemoteService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RmiClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            BookRemoteService bookService = (BookRemoteService) registry.lookup("BookRemoteService");

            // Пример использования RMI сервиса
            List<BookRMI> books = bookService.getAllBooks(0, 100);
            books.forEach(book -> System.out.println(book.getTitle()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Пример Maven конфигурации

`pom.xml` этого проекта выглядит следующим образом:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.edu</groupId>
    <artifactId>rmi-client</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.github.jegius</groupId>
            <artifactId>rmi-dependency</artifactId>
            <version>-a694e822f5-1</version>
        </dependency>
    </dependencies>
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
</project>
```

---

Для получения актуальной информации об использовании JitPack посетите [официальную документацию JitPack](https://jitpack.io/docs/).
