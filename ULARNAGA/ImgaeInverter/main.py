import cv2 as cv
import os

file_path = r"C:\Users\HAPE\Desktop\Random\ULARNAGA\ImgaeInverter\image.jpg"
output_path = r"C:\Users\HAPE\Desktop\Random\ULARNAGA\ImgaeInverter\inverted.jpg"

if not os.path.exists(file_path):
    print("File tidak ditemukan!")
else:
    print("File ditemukan!")
    images = cv.imread(file_path)

    if images is None:
        print("Error: Gambar tidak ditemukan atau gagal dimuat.")
    else:
        inverted_image = cv.bitwise_not(images)
        cv.imwrite(output_path, inverted_image)
        print(f"Gambar hasil inversi disimpan sebagai: {output_path}")

        cv.imshow("Original Image", images)
        cv.imshow("Inverted Image", inverted_image)
        cv.waitKey(0)
        cv.destroyAllWindows()
