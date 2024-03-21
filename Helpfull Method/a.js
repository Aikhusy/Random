var konten = [
    {
        name: "Soto",
        price: 12000,
        id: "1"
    },
    {
        name: "Rawon",
        price: 15000,
        id: "2"
    },
    {
        name: "Bakso",
        price: 10000,
        id: "3"
    },
    {
        name: "Pecel",
        price: 10000,
        id: "4"
    },
    {
        name: "Bebek",
        price: 15000,
        id: "5"
    }
];

var linkss = "https://crudcrud.com/api/3dffb898d7be41f2bd98f55e8e2c2038/menus";

function SendAPITOServer(links, content) {
    fetch(links, {
        headers: { "Content-Type": "application/json; charset=utf-8" },
        method: 'POST',
        body: JSON.stringify(content)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));
}

SendAPITOServer(linkss, konten);
