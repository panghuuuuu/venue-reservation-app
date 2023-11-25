const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    "/reservee",
    createProxyMiddleware({
      target: "http://localhost:9997",
      changeOrigin: true,
    })
  );
};
