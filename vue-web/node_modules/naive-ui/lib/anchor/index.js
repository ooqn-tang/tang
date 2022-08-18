"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.NAnchorLink = exports.NAnchor = void 0;
var AnchorAdapter_1 = require("./src/AnchorAdapter");
Object.defineProperty(exports, "NAnchor", { enumerable: true, get: function () { return __importDefault(AnchorAdapter_1).default; } });
var Link_1 = require("./src/Link");
Object.defineProperty(exports, "NAnchorLink", { enumerable: true, get: function () { return __importDefault(Link_1).default; } });
