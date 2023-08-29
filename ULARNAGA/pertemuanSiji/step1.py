# Mengimport yang di butuhkan
import numpy as np
import pandas as pd
import cv2
import skimage as sk
from PIL import Image
import matplotlib.pyplot as plt

def displayImage(image,namaWindows):
    readImage = cv2.imread(image)
    cv2.imshow(namaWindows,readImage)
    cv2.waitKey(0)

def closeWindows(namaWindows):
    cv2.destroyWindow(namaWindows)


urls = [
    "https://iiif.lib.ncsu.edu/iiif/0052574/full/800,/0/default.jpg",
    "https://iiif.lib.ncsu.edu/iiif/0016007/full/800,/0/default.jpg",
    "https://placekitten.com/800/571"
]

for i in urls:
