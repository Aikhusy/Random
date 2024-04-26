=============================================
php bin/console doctrine:database:create

create database menggunakan doktrine
=============================================
php bin/console make:entity

make entity/ model

=============================================
MIGRATIONS
=============================================

php bin/console make:migration

create migrations

php bin/console doctrine:migrations:migrate

untuk migrasi

>>kesimpulannya untuk symfony itu migrasinya dibuat entity dahulu, kemudian di buatkan versi migrasinya yang berbentuk seperti github, lalu jika ingin mengupdate migrasi, tinggal di running lagi

=============================================
CONTROLLERS
=============================================

php bin/console make:controller ProductController