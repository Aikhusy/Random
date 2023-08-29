import numpy as np
import pandas as pd
import cv2 as cv
import skimage as sk
from PIL import Image
import matplotlib.pyplot as plt

def displayImage(image,namaWindows):
    readImage = cv.imread(image)
    cv.imshow(namaWindows,readImage)
    cv.waitKey(0)

def closeWindows(namaWindows):
    cv.destroyWindow(namaWindows)

displayImage('/gambar/KTP1.png','kon')