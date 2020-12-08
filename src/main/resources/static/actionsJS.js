function submitProduct(){

/*

{	"userName": "nick",
	"email": "nick@gmail.com"
}

*/

    var	actionMethod = "POST"
    var	actionUrl = "http://localhost:1005/customer"


    console.log("This is a nameee: "+$('#name').val());
    sendData = {"userName":$('#name').val(),

        "email":$('#price').val()
    }

    $.ajax({
        beforeSend: function (xhr) {
        },
        url: actionUrl,
        dataType: 'json',
        type: actionMethod,
        contentType: 'application/json',
        data: JSON.stringify( sendData ),
        processData: false,
        success: function( data, textStatus, jQxhr ){
            alert( JSON.stringify( data ) );
        },
        error: function( jqXhr, textStatus, errorThrown ){
            console.log( "errorThrown" );
        }
    });

}