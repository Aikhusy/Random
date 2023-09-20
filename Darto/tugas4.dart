import 'dart:io';

void main() {
  double num1, num2;
  
  stdout.write("Masukkan angka pertama: ");
  num1 = double.tryParse(stdin.readLineSync() ?? "") ?? 0.0;
  
  stdout.write("Masukkan operasi");
  String choice = stdin.readLineSync() ?? "";

  stdout.write("Masukkan angka kedua: ");
  num2 = double.tryParse(stdin.readLineSync() ?? "") ?? 0.0;
  
  double result = 0.0;

  switch (choice) {
    case "+":
      result = num1 + num2;
      break;
    case "-":
      result = num1 - num2;
      break;
    case "*":
      result = num1 * num2;
      break;
    case "/":
      if (num2 != 0) {
        result = num1 / num2;
      } else {
        print("Pembagian dengan nol tidak diizinkan.");
        return;
      }
      break;
    default:
      print("Operasi tidak valid.");
      return;
  }

  print("Hasil: $result");
}