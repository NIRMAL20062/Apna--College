from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
import time

# Path to your Edge WebDriver (msedgedriver)
driver = webdriver.Edge()

search_queries = [
    "python tutorial",
    "java basics",
    "AI trends 2025",
    "latest technology news",
]

# Open Bing
driver.get("https://www.bing.com")

for query in search_queries:
    search_box = driver.find_element(By.NAME, "q")
    search_box.clear()
    search_box.send_keys(query)
    search_box.send_keys(Keys.RETURN)
    time.sleep(2)  # wait before next search

driver.quit()
