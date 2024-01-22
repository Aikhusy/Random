composer create-project laravel/laravel example-app

--controller resource, model
php artisan make:controller <name> -crm


--make stub file--
php artisan stub:publish

composer update

composer install

make .env


--fortify--
composer require laravel/fortify

php artisan vendor:publish --provider="Laravel\Fortify\FortifyServiceProvider"

php artisan migrate

config/app.php{
        'providers' => [
        // ...

        Laravel\Fortify\FortifyServiceProvider::class,
    ],
}

FortifyServiceProvider