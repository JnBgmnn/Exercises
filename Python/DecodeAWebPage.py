'''
Created on 11.01.2018

@author: Jan
'''

import requests
from bs4 import BeautifulSoup


url = 'http://nytimes.com'
r = requests.get(url)
r_html = r.text
soup = BeautifulSoup(r_html, "lxml")
articles = soup.find_all("article")
for article in range(len(articles)):
    var = articles[article].find("h2")
    if var != None:
        print(var.get_text())