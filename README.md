<h1 style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Шифр Цезаря - реализация на Java</h1>

---
<h2 style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Содержание</h2>
<ul style="font-family: 'Manrope_Cut_008 Medium', sans-serif">
    <li><a href="#обзор">Обзор</a></li>
    <li><a href="#функциональность">Функциональность</a></li>
    <li><a href="#технологии">Технологии</a></li>
    <li><a href="#установка">Установка</a></li>
    <li><a href="#использование">Использование</a></li>
    <li><a href="#структура-проекта">Структура проекта</a></li>
    <li><a href="#лицензия">Лицензия</a></li>
</ul>

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Обзор</span>

<p id="обзор" style="font-family: 'Manrope_Cut_008 Medium', sans-serif">
Веб-приложение для шифрования и дешифрования текстовых файлов с использованием классического шифра Цезаря. 
Поддерживает работу с английским и русским алфавитами через удобный веб-интерфейс.
</p>

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Функциональность</span>

<div id="функциональность" style="font-family: 'Manrope_Cut_008 Medium', sans-serif">

- 🔐 **Шифрование/дешифрование** текстовых файлов
- 🌐 **Поддержка двух алфавитов** английский и русский
- 📁 **Загрузка файлов** через веб-интерфейс
- 🎯 **Валидация ввода** с ограничением ключа
- 🐳 **Docker контейнеризация**
- 🔄 **Циклический сдвиг** символов в пределах алфавита

</div>

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Технологии</span>

<div id="технологии" style="font-family: 'Manrope_Cut_008 Medium', sans-serif">

- **Backend**: Java 21, Spring Boot 3.1+
- **Frontend**: Thymeleaf, HTML5, CSS3, JavaScript
- **Build Tool**: Maven
- **Containerization**: Docker
- **Fonts**: Manrope_Cut_008
- **Encoding**: UTF-8

</div>

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Установка</span>
<a id="установка"> </a>

### <span style="font-family: 'Manrope_Cut_008 Medium', sans-serif">Предварительные требования</span>

- Java 21
- Maven 3.8+
- Docker (опционально)

### <span style="font-family: 'Manrope_Cut_008 Medium', sans-serif">Локальная установка</span>

```
# Склонировать репозиторий
git clone https://github.com/VasilevYuV/caesar-cipher

# Сборка проекта (создание JAR файла)
mvn clean package -DskipTests

# Запуск приложения
java -jar target/caesar-cipher-*.jar
```

### <span style="font-family: 'Manrope_Cut_008 Medium', sans-serif">Docker установка</span>

```
# Склонировать репозиторий
git clone https://github.com/VasilevYuV/caesar-cipher

# Сборка проекта (создание JAR файла)
./mvnw clean package -DskipTests

# Собрать Docker образ
docker build -t caesar-cipher -f docker/Dockerfile .

# Запустить контейнер
docker-compose -f docker/compose.yaml up

# Остановить
docker-compose -f docker/compose.yaml down
```

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Использование</span>

<div id="использование" style="font-family: 'Manrope_Cut_008 Medium', sans-serif">

1. **Откройте приложение** по адресу `http://localhost:8080`
2. **Выберите файл** для обработки (.txt формат)
3. **Выберите язык** алфавита (русский/английский)
4. **Выберите режим** (шифрование/дешифрование)
5. **Укажите ключ** сдвига (1-25 для английского, 1-31 для русского)
6. **Нажмите "Выполнить"** для обработки
7. **Сохраните результат** используя кнопку "Сохранить результат"

</div>

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Структура проекта</span>
<a id="структура-проекта"> </a>

```
caesar-cipher/
├── src/main/java/
│   └── com/example/caesarcipher/
│       ├── CaesarCipherApplication.java
│       ├── controller/
│       │   ├── CaesarCipherController.java
│       │   └── CaesarCipher.java
│       └── model/
├── src/main/resources/                                 
│   ├── templates/                                        
│   │   ├── index.html                                    
│   │   └── result.html                                    
│   └── application.properties                            
├── docker/
│   ├── Dockerfile
│   └── compose.yaml
├── pom.xml
├── LICENSE
└── README.md
```

---

## <span style="font-family: 'Manrope_Cut_008 ExtraBold', sans-serif">Лицензия</span>
<a id="лицензия"> </a>
<p style="font-family: 'Manrope_Cut_008 Medium', sans-serif">
Этот проект распространяется под лицензией MIT. Подробности см. в файле 
<a href="https://github.com/VasilevYuV/caesar-cipher/blob/develop/LICENSE">LICENSE</a>.
</p>

---
