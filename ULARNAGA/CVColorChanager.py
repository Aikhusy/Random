import numpy as np
import pandas as pd
import cv2
from google.colab.patches import cv2_imshow # for image display
from skimage import io
from skimage import transform
from PIL import Image
import matplotlib.pylab as plt

def displayImage(image):
    readImage = cv2.imread(image)
    cv2_imshow(readImage)
    return readImage

def brightnessAndContrast(image,alpha,beta):
    editedImage=cv2.convertScaleAbs(image, alpha=alpha, beta=beta)
    cv2_imshow(editedImage)
    return editedImage

def invertedImage(image):
    inverted_image = cv2.bitwise_not(image)
    cv2_imshow(inverted_image)
    return invertedImage

def logaritmikBrightness(image,batas):
    convertImage = (np.log1p(image) / np.log1p(batas)) * batas
    convertedImageToInt= np.uint8(convertImage)
    cv2_imshow(convertedImageToInt)
    return convertedImageToInt

def grayscaleImage(image):
    grayImage = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    cv2_imshow(grayImage)
    return grayImage

gambar='/content/sample_data/cupu.png'

gambarReady=displayImage(gambar)

gambarCerah=brightnessAndContrast(gambarReady,1.5,20)

gambarTerbalik= invertedImage(gambarReady)

logaritmikImage=logaritmikBrightness(gambarReady,255)

grayImage=grayscaleImage(gambarReady)