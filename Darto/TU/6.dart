void main(List<String> args) {
  var gift = {'first': 'partridge', 'second': 'turtledoves', 'fifth': 1};

  var nobleGases = {
    2: 'helium',
    10: 'neon',
    18: 2,
  };

  var mhs1 = <String, String>{
    'nama': 'Syaikhul Shafwan R',
    'nim': '2141720105'
  };

  var mhs2 = <int, String>{0: 'Syaikhul Shafwan R', 1: '2141720105'};

  gift['first'] = 'partridge';
  gift['second'] = 'turtledoves';
  gift['fifth'] = 'golden rings';
  gift['nama'] = 'Syaikhul Shafwan R';
  gift['nim'] = '2141720105';

  nobleGases[0] = 'Syaikhul Shafwan R';
  nobleGases[1] = '2141720105';
  nobleGases[2] = 'helium';
  nobleGases[10] = 'neon';
  nobleGases[18] = 'argon';

  print(gift);
  print(nobleGases);
  print(mhs1);
  print(mhs2);
}
