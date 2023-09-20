import 'dart:io';

void main() {
  stdout.write("Masukkan jumlahnya: ");
  int num1 = int.tryParse(stdin.readLineSync() ?? "") ?? 0;

  while (num1 % 2 == 0) {
    stdout.write("Masukkan jumlahnya (harus ganjil): ");
    num1 = int.tryParse(stdin.readLineSync() ?? "") ?? 0;
  }

  for (int row = 1; row <= num1; row += 2) {
    int totalSpace = (num1 - row) ~/ 2; 
    print((" " * totalSpace) + ("*" * row) + (" " * totalSpace));
  }
}