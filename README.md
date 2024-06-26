# BillManager

BillManager is a home budgeting program designed to help you manage your finances efficiently. It allows you to track your income, expenses, and savings to stay on top of your budget.


## Main Features
- **Organization of Expenses and Income:** Easily record and categorize your various sources of income and types of expenses.
- **Reminders and Future Payments:** Set up reminders for future payments, recurring expenditures, and future incomes to help plan your budget (not implemented yet).
- **Graphical Analysis:** Draw graphs to visualize your financial data (not implemented yet).
- **Computer Vision for Data Input:** Use computer vision to allow easier input of data (will be implemented when base functionalities are completed).
- **LLMs for Analytics:** Leverage large language models to assist with financial analytics and insights (will be implemented when base functionalities are completed).

## Requirements
To build and run BillManager, you need to have the following installed:

- **JDK (Java Development Kit):** Version 8 or higher.
- **Android SDK:** You can download it from [Android Developers](https://developer.android.com/studio).
- **Gradle:** Usually included with Android Studio, but can also be installed separately.
- **ADB (Android Debug Bridge):** Included with the Android SDK.



Ensure that the `JAVA_HOME` and `ANDROID_HOME` environment variables are set properly.

### For Linux
For Linux, you can set environment variables in the terminal using commands like:
```bash
export JAVA_HOME=/path/to/your/jdk
export ANDROID_HOME=/path/to/your/android/sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

### For Windows
For Windows, you can set environment variables using Command Prompt (CMD). Here's how to do it:

1. **Open Command Prompt as Administrator.**
2. **To set JAVA_HOME, use the following command (replace `C:\path\to\your\jdk` with the actual path to your JDK installation directory):**
   ```cmd
   setx JAVA_HOME "C:\path\to\your\jdk"
   ```
3. **To set ANDROID_HOME, use the following command (replace `C:\path\to\your\android\sdk` with the actual path to your Android SDK directory):**
   ```cmd
   setx ANDROID_HOME "C:\path\to\your\android\sdk"
   ```
4. **To add the Android SDK tools and platform-tools directories to the PATH variable, use the following commands:**
   ```cmd
   setx PATH "%PATH%;%ANDROID_HOME%\tools;%ANDROID_HOME%\platform-tools"
   ```

After setting these environment variables, make sure to restart any open command prompts or terminals for the changes to take effect.

## Installation
To install and set up BillManager, follow these steps:

### For Linux
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Vlad421/BillManager.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd BillManager
   ```
3. **Build the project using Gradle:**
   ```bash
   ./gradlew build
   ```
4. **To build the APK file:**
   ```bash
   ./gradlew assembleDebug
   ```
5. **Install the APK on your Android device:**
   ```bash
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```

### For Windows
1. **Clone the repository:**
   ```cmd
   git clone https://github.com/Vlad421/BillManager.git
   ```
2. **Navigate to the project directory:**
   ```cmd
   cd BillManager
   ```
3. **Build the project using Gradle:**
   ```cmd
   gradlew.bat build
   ```
4. **To build the APK file:**
   ```cmd
   gradlew.bat assembleDebug
   ```
5. **Install the APK on your Android device:**
   - **Connect your Android device to your computer via USB.**
   - **Open a command prompt and navigate to the directory where ADB is located (usually `platform-tools` inside your Android SDK directory).**
   - **Run the following command to install the APK:**
     ```bash
     adb install -r app\build\outputs\apk\debug\app-debug.apk
     ```

Make sure you have the necessary environment variables set up, such as `JAVA_HOME`, `ANDROID_HOME`, and that the Android Debug Bridge (`adb`) is accessible from the command line.

## Contributor Guidelines
Contributions to BillManager are welcome! Please follow these guidelines when contributing:

- Fork the Repository: If you're planning to contribute, fork the repository to your GitHub account.
- Branches: Create a new branch for your contributions. Branch names should be descriptive of the feature or fix you're working on.
- Commit Messages: Write clear and descriptive commit messages that explain the purpose of your changes.
- Pull Requests: Submit a pull request from your fork's branch to the main repository's branch. Provide a detailed description of your changes in the pull request.
- Testing: Ensure that your changes are tested thoroughly. If applicable, include tests with your pull request.
- Documentation: Update documentation, such as README files or inline code comments, to reflect your changes if necessary.
- Be Respectful: Be respectful to others in your interactions on GitHub, including in issues and pull requests.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.
