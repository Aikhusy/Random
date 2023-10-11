void main(List<String> args) {
  var names1 = <String>{};
  Set<String> names2 = {};

  names1.add('Syaikhul Shafwan R');
  names1.add('2141720105');

  names2.addAll(names1);

  print(names1);
  print(names2);
}
