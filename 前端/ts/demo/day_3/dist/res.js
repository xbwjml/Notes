define("m", ["require", "exports"], function (require, exports) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    exports.hi = void 0;
    exports.hi = '嗨';
    let x = "kk";
});
define("app", ["require", "exports", "m"], function (require, exports, m_js_1) {
    "use strict";
    Object.defineProperty(exports, "__esModule", { value: true });
    console.log('hello');
    let a = 10;
    let b = 20;
    let c = 30;
    console.log(m_js_1.hi);
});
let aaa = '666';
