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

def coordinateImage(image):
    readImage = cv2.imread(image)
    imageReal = cv2.cvtColor(readImage, cv2.COLOR_BGR2RGB)
    plt.imshow(imageReal)

def kotak(image,yStart,yEnd,xStart,xEnd,b,g,r):
    for y in range (yStart,yEnd):
      for x in range (xStart,xEnd):
        image[x,y] = [b,g,r]
    return image

def closeWindows(namaWindows):
    cv2.destroyWindow(namaWindows)

gambar1='/content/sample_data/KTP1.png'

ktp=displayImage(gambar1)
coordinateImage(gambar1)

copy=np.copy(ktp)
garisNIK=kotak(copy,200,550,130,170,255,0,0)
garisNama=kotak(garisNIK,220,500,170,200,255,255,255)
final_frame = cv2.hconcat((ktp, garisNama))
cv2_imshow(final_frame)