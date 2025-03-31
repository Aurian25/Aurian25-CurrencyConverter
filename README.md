# Aurian25-CurrencyConverter

Currency Converter Application
A simple Java-based Currency Converter that fetches real-time exchange rates using an external API.

Features
Supports multiple currencies (USD, EUR, INR, GBP, etc.)

Fetches real-time exchange rates via an API

Simple GUI using Swing

Project Structure
CurrencyConverter
│── src
│   ├── com
│   │   ├── CurrencyConverter.java       (Main class)
│   │   ├── CurrencyConverterApp.java    (GUI class)
│   │   ├── CurrencyConverterService.java (Handles API calls)
│── lib
│   ├── json-20210307.jar (External JSON Library)
Setup & Installation
1. Clone the Repository
git clone https://github.com/your-username/CurrencyConverter.git
cd CurrencyConverter
2. Add JSON Library
Download json-20210307.jar from here.

Copy it into the lib/ folder.

In Eclipse:

Right-click the project → Build Path → Add External JARs...

Select json-20210307.jar and click Apply and Close.

3. Get an API Key
Sign up at ExchangeRate-API.

Replace YOUR_API_KEY in CurrencyConverterService.java:

private static final String API_KEY = "your_actual_api_key_here";
private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
4. Run the Application
In Eclipse: Click Run (Ctrl + F11).

From Terminal:

javac -cp lib/json-20210307.jar src/com/*.java
java -cp .:lib/json-20210307.jar com.CurrencyConverter
Future Enhancements
Offline Mode (cache exchange rates for offline use)

Historical Data (view past exchange rates)

Mobile App Version using JavaFX

Contributing
Fork the repository.

Create a new branch (git checkout -b feature-branch).

Commit changes (git commit -m "Added new feature").

Push (git push origin feature-branch).

Open a Pull Request.

License
This project is licensed under the MIT License.

💡 Contributions are welcome! 😊
