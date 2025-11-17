# 🛒 Automation Project 3 – Selenium Practice on Flipkart



---

## 📍 **Project Overview**
This project automates major user interactions on the **Flipkart** website using **Selenium WebDriver** and **Java** (non-Maven setup).  
It focuses on handling **dynamic web elements** such as changing locators, JavaScript-based hover menus, and conditional popups.  
The project covers a full end-to-end testing flow on a live e-commerce site, ensuring real-world exposure to automation challenges.

---

## ⚙️ **Tools & Technologies Used**
| Component | Description |
|------------|-------------|
| **Programming Language** | Java |
| **Automation Tool** | Selenium WebDriver |
| **Browser** | Firefox |
| **IDE** | Eclipse |
| **Driver** | GeckoDriver |
| **Testing Site** | [https://www.flipkart.com](https://www.flipkart.com) |

---

## 🧩 **Automation Tasks Implemented**

### **Task 1: Browser Launch and Page Title Verification**
- Launched Flipkart and verified the title.

### **Task 2: Handle Login Popup**
- Closed login popup if present.
- Used conditional handling (`try-catch`) to manage dynamic popup behavior.

### **Task 3: Product Search**
- Located the search box and searched for “mobile”.

### **Task 4: Capture Product Listings**
- Captured all product titles using `findElements()`.
- Printed total count and first five products in the console.

### **Task 5: Mouse Hover on Menu**
- Performed mouse hover using `Actions.moveToElement()`.
- Flipkart’s **Electronics** and **Fashion** menus use dynamic JS hovers, so *Beauty, Food, Toys & More* was used for demonstration.
- Dropdown remained visible for 10 seconds.

### **Task 6: Click on Product and Handle New Tab**
- Clicked the product “IQOO Z10X 5G (Titanium, 128 GB)”.
- Opened in a **new tab** using JavaScript `window.open()` and switched using `getWindowHandles()`.

### **Task 7: Verify Product Details**
- Verified product name and price on product details page using `By.cssSelector`.

### **Task 8: Take Screenshot**
- Captured screenshot of search results using `TakesScreenshot`.

### **Task 9: Close Browser**
- Closed browser using `driver.close()` and ended session with `driver.quit()`.

---

## ✅ **Test Case Summary**

| Task | Description | Result |
|------|--------------|--------|
| 1 | Browser launch and title verification | ✅ Passed |
| 2 | Handle login popup | ✅ Passed |
| 3 | Search for product | ✅ Passed |
| 4 | Capture product listings | ✅ Passed |
| 5 | Mouse hover on menu | ✅ Passed |
| 6 | Click product & handle new tab | ✅ Passed |
| 7 | Verify product details | ✅ Passed |
| 8 | Capture screenshot | ✅ Passed |
| 9 | Close browser | ✅ Passed |

**Total Executed:** 9 **Passed:** 9 **Failed:** 0  

---

## 🧠 **Challenges & Solutions**

| Challenge | Cause | Solution |
|------------|--------|-----------|
| Dropdown not showing for Electronics/Fashion | Dynamic JavaScript-driven hover not triggered by Selenium | Used *Beauty, Food, Toys & More* for hover demonstration |
| Changing locators | React-based dynamic class names | Used XPath and text-based locators |
| Product opened in new tab | JavaScript `window.open()` | Verified successful tab switch |
| Dropdown disappearing quickly | Hover timeout | Added 10-second wait for visibility |
| Login popup not always visible | Popup appears only in new sessions | Added conditional handling with `try-catch` |

---

## 🧾 **Project Folder Structure**
FLIPKARTPROJECT/
│
├── src/
│ └── FLIPKART/
│ └── FLIPKARTPROJECT.java
│
├── flipkart_search.png
└── README.md

## 🧠 **Learning Outcomes**
- Understood automation of **dynamic web applications** using Selenium.  
- Learned to handle **conditional elements, multiple windows, and popups**.  
- Implemented synchronization using **explicit waits**.  
- Gained experience in organizing, executing, and documenting automation tasks.  


## 🏁 **Conclusion**
All major Flipkart functionalities were successfully automated using Selenium WebDriver (Java).  
The project demonstrates handling of dynamic elements, hover actions, window management, and real-time validation.  

**Overall Result:** ✅ *Project Completed Successfully*

---














