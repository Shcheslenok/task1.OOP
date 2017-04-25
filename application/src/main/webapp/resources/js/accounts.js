$(document).ready(function() {

   $('.js-action-block').on('click', function () {
       var self = $(this);
       var keyValue = self.attr('data-key');
       $.ajax(location.href, {method: 'POST', data: {key: keyValue},
           success: function (result) {
           self.closest('td').prev().text(result);
       }
       });
   });

    $('.js-action-count').on('click', function () {
         var keyValue = "count";
        $.ajax(location.href, {method: 'POST', data: {key: keyValue},
            success: function (result) {
                document.getElementById("label").innerHTML = result;
            }
        });
    });

    $('#accounts').DataTable();
} );