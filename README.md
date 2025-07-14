# Corpse: Kibou no Hana  _希望之花_


> “止まるんじゃねぇぞ……”  
> _不要停下来啊..._

## 🕊️ 概要 | Overview

本模组是 [**Corpse**](https://www.curseforge.com/minecraft/mc-mods/corpse) 的一个趣味附属模组。它通过 Mixin 技术，修改了原版尸体的渲染逻辑，使当玩家脸朝下倒地时，其尸体会以一种特别的姿势呈现——正是来自《机动战士高达 铁血的奥尔芬斯》中奥尔加·伊兹卡（Orga Itsuka）壮烈牺牲时的那副令人印象深刻的倒地动作。

This mod is an **extension for [Corpse](https://www.curseforge.com/minecraft/mc-mods/corpse)** that reworks the player's corpse pose when lying face-down. Inspired by the iconic (and ironically memed) death scene of **Orga Itsuka** from _Mobile Suit Gundam: Iron-Blooded Orphans_, this mod adjusts the rendering to replicate his dramatic fall.

## 🧠 特点 | Features

- 🎭 重现奥尔加团长的“不要停下来啊”姿势  
  Faithfully recreates the infamous Orga death pose.
- 🧍‍♂️ 仅影响渲染为尸体的 DummyPlayer，不会干扰普通玩家或其他模型  
  Pose changes are isolated to corpses only; no impact on players or statue mods.


## 📷 预览 | Screenshots

_<img width="553" height="672" alt="image" src="https://github.com/user-attachments/assets/4e8b1a75-4321-432f-b630-6fe41d8f2ab5" />
_

## 📦 前置 | Requirements

- [Corpse](https://www.curseforge.com/minecraft/mc-mods/corpse)


## 🧩 配置说明 | Config Behavior

- 模组只在玩家尸体为脸朝下（`corpse.lie_on_face=true`）时才会生效  
  Only activates when `corpse.lie_on_face` config is set to `true`.

- 为了提升使用体验，本模组通过 Mixin 技术，将 `corpse.lie_on_face` 配置项的默认值改为了 `true`，无需手动更改配置文件。

To improve ease of use, this mod modifies the default value of the `corpse.lie_on_face` setting to `true` via Mixin, so users don’t need to manually edit config files.

> 📁 注意：Corpse 模组在 Minecraft 1.20.1 中的配置文件是按存档分开的，保存在 `saves/<存档名>/serverconfig/corpse-server.toml`。  
> 新存档会自动使用新默认值，但已有存档需要你自行前往该路径将该选项设为 `true` 才能生效。

> 📁 Note: In Minecraft 1.20.1, Corpse’s config is stored **per world**, located at `saves/<world_name>/serverconfig/corpse-server.toml`.  
> The new default applies automatically in **new saves**, but for existing worlds, you may need to manually set `corpse.lie_on_face=true` for it to take effect.


  

---

> 这是一个向角色致敬、又带点黑色幽默色彩的模组。  
> _A mod both darkly comedic and strangely respectful._  
>  
