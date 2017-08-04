/**
 * Created by AsusIT on 03.08.2017.
 */
<script>
// just for the demos, avoids form submit
jQuery.validator.setDefaults({
    debug: true,
    success: "valid"
});
$( "#myform" ).validate({
    rules: {
        field: {
            required: true
        }
    }
});
</script>