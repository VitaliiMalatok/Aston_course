# 💪 MTS Online Payment Automation Tests

Этот проект содержит автотесты для проверки онлайн-оплаты на сайте **MTS.by**.  
Тесты написаны на Java + Selenium + TestNG, отчёты формируются через **Allure**, сборка — через **Maven**, а запуск автоматизирован через **Jenkins**.

---

## 📁 Структура проекта

- `src/test/java/` — тесты и вспомогательные классы
- `logs/` — лог-файлы
- `target/allure-results/` — результаты выполнения тестов для Allure
- `target/allure-report/` — HTML-отчёт Allure после генерации

---

## ⚙️ Технологии

- **Java 11+**
- **Selenium WebDriver**
- **TestNG**
- **Allure Report**
- **Maven**
- **Jenkins**
- **Log4j2**
- **Telegram Bot API** — отправка отчётов в Telegram

---

## 🚀 Как запустить тесты вручную

1. Установи зависимости:

```bash
mvn clean install
```

2. Запусти тесты:

```bash
mvn test
```

3. Сгенерируй и открой Allure-отчёт:

```bash
allure serve target/allure-results
```

---

## 🧰 Jenkins CI/CD

Тесты автоматически запускаются через Jenkins:

- ✅ GitHub-репозиторий подключён
- ✅ Прогоняються раз в час через тригер
- ✅ Allure-отчёты сохраняются и отображаются в Jenkins UI
- ✅ Уведомления об успешных/провальных тестах отправляются в Telegram

---

## 📬 Telegram-интеграция

При каждом запуске:

- В Telegram-чат отправляется:
  - Статус теста ✅/❌
  - Время выполнения
  - Краткий лог(последние 20 строк из последнего лог файла)

Настройки Telegram-бота находятся в `TelegramBot.java`.

---

## 📌 Пример тестов

- Проверка плейсхолдеров на форме оплаты
- Проверка соответствия введённых данных в iframe оплаты

---

## 📋 Автор

- **Vitali Molotok**  
  [GitHub: @VitaliiMalatok](https://github.com/VitaliiMalatok)

---

