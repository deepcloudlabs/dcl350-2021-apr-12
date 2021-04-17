var AppConfig = {
    REST_API_BASE_URL: "http://localhost:4242/market/api",
    WS_URL: "http://localhost:7800/stockmarket/api/v1/changes",
    I18N_CONFIG: {
        lng: "en",
        resGetPath: "resources/__ns__-__lng__.json",
        fallbackLng: "en"
    },
    TOASTR_CONFIG : {
        debug: false,
        timeOut: 500,
        extendedTimeOut: 100,
        fadeIn: 25,
        fadeOut: 25,
        positionClass: 'toast-top-right'
    }
};
