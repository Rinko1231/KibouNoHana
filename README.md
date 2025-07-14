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

- ✅ 模组仅在玩家尸体为**脸朝下**时生效（即 `corpse.lie_on_face=true`）  
  ✅ This mod only takes effect when the player's corpse is **face-down** (`corpse.lie_on_face=true`).

- ⚙️ 为了提升使用体验，模组通过 Mixin 技术将该配置的默认值设为 `true`，一般情况下**无需手动修改配置文件**  
  ⚙️ To improve user experience, the mod sets this config's default value to `true` via Mixin — so **manual editing is usually unnecessary**.

- 📁 注意：在 Minecraft 1.20.1 中，Corpse 模组的配置文件是**每个存档独立的**，路径为：  
  `saves/<存档名>/serverconfig/corpse-server.toml`  
  新建存档会自动使用新默认值，但旧存档可能需要你**手动修改该文件**中的 `corpse.lie_on_face=true`

- 📁 Note: In Minecraft 1.20.1, Corpse’s config is stored **per world** at:  
  `saves/<world_name>/serverconfig/corpse-server.toml`  
  The new default applies automatically for **new worlds**, but for **existing saves**, you may need to manually set `corpse.lie_on_face=true`.



  
---

> 这是一个向角色致敬、又带点黑色幽默色彩的模组。  
> _A mod both darkly comedic and strangely respectful._  
>  
