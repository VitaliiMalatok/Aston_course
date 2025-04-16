## 📬 Telegram-интеграция

При каждом запуске:

- В Telegram-чат отправляется:
  - Статус теста ✅/❌
  - Время выполнения
  - Краткий лог (последние 20 строк из последнего лог-файла)

Настройки Telegram-бота находятся в `TelegramBot.java`.

### 📸 Пример уведомления в Telegram:

![Telegram report example](screenshots/Screenshot%20(45).png)

### 📸 Пример уведомления в Telegram(тест упал):

![Telegram report example](screenshots/Screenshot%20(46).png)

---

## 📊 Allure-отчёты

- Автоматически формируются после каждого прогона
- Отображают информацию о прохождении каждого теста
- Можно просматривать историю запусков и детали по каждому шагу

### 📸 Пример Allure-отчёта:

![Allure report example](screenshots/Screenshot%20(44).png)



