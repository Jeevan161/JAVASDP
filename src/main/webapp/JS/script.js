/**
 * 
 */
$(window).on('scroll load' ,function()
{
    if($(window).scrollTop() > 30)
    {
        $('#header').addClass('header-active')
        
    }
    else
    {
        $('#header').removeClass('header-active')
       
    }
})

function toggleNavbar() {
    var navbar = document.getElementById("cs-navbar");
    navbar.classList.toggle("open");
}
