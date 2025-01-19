---
layout: home

hero:
  name: "OSK Tools"
  text: "Windows 锁屏工具箱"
  tagline: "开源 · 安全 · 快捷"
  actions:
    - theme: brand
      text: 关于 OSK Tools
      link: /docs/guide/

    - theme: alt
      text: 快速开发
      link: /docs/dev/

    - theme: alt
      text: GitHub
      link: "https://github.com/binstdio/OSK-Tools"
  //image:
      src: /.vitepress/assets/home-image.jpg
      alt: VitePress
features:
  - title: 让我们，开始吧！
    details: Let's get started!
    link: /docs/guide/
---

<style>
:root {
  --vp-home-hero-name-color: transparent;
  --vp-home-hero-name-background: -webkit-linear-gradient(120deg, #bd34fe 30%, #41d1ff);

  --vp-home-hero-image-background-image: linear-gradient(-45deg, #007cfd 10%, #fffffd  100%);
  --vp-home-hero-image-filter: blur(44px);
}

@media (min-width: 640px) {
  :root {
    --vp-home-hero-image-filter: blur(56px);
  }
}

@media (min-width: 960px) {
  :root {
    --vp-home-hero-image-filter: blur(68px);
  }
}
</style>
