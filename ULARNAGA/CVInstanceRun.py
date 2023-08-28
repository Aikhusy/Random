import cv2 as cv

def displayImage(image,namaWindows):
    readImage = cv.imread(image)
    cv.imshow(namaWindows,readImage)
    cv.waitKey(0)

def closeWindows(namaWindows):
    cv.destroyWindow(namaWindows)




