void main(List<String> args) {
  (String, String) swapvar = ('Syaikhul Shafwan R', '2141720105');
  print(swapvar);
  swapvar = tukar(swapvar);
  print(swapvar);
}

(String, String) tukar((String, String) record) {
  var (a, b) = record;
  return (b, a);
}
