yieldUnescaped '<!DOCTYPE html>'
html {
    head {
        title('Spring security template !')
        link(rel: 'stylesheet', href: '/css/bootstrap.min.css')
    }
    body {
        div(class: 'container') {
            p("Hello : $user")
        }
    }
}