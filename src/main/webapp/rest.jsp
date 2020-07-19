<!DOCTYPE html>
<html>
    <head>
        <title>IBAN Check</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function getList() {
                fetch("rest/", {
                    method: "GET",
                    cache: "no-cache",
                    credentials: "same-origin",
                    headers: {
                        "Accept": "application/json",
                        "Content-Type": "application/json"
                    }
                })
                    .then(function(response) {
                        return response.json();
                    })
                    .then(function(json) {

                        for (var i = 0; i < json.length; i++) {

                            console.log(json[i])
                        }
                    })
            }

            function add() {
                const IbanInput = document.getElementById("numberIBAN");
                const number = {
                    numberIBAN: IbanInput.value
                };
                fetch("rest/", {
                    method: "POST",
                    cache: "no-cache",
                    credentials: "same-origin",
                    headers: {
                        "Accept": "application/json",
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(number)
                })
            }
        </script>
    </head>
    <body>

        IBAN: <input id="numberIBAN"><br>

        <button onclick="getList()">Get List</button>
        <button onclick="add()">Add to List</button>

        <p>Check browsers console</p>

    </body>
</html>
