# 🚀 LeetCode Vault — All Solutions (Clean · Explained · Emoji-powered) 🧠💎

**All LeetCode solutions — organized, explained, and ready-to-run.**

---

[![Awesome](https://img.shields.io/badge/awesome-yes-brightgreen)]()
[![Contributions Welcome](https://img.shields.io/badge/contributions-welcome-blue)]()
[![License: MIT](https://img.shields.io/badge/license-MIT-blueviolet)]()

---

## 🔖 Tagline

**All LeetCode Solutions — Organized · Explained · Ready-to-run ⚡️📚**

---

## 📚 What you'll find

* ✅ Clean, commented solutions with **time & space complexity**
* 🧠 Short approach explanation & quick intuition for each problem
* 🧪 Basic test cases included for fast verification
* 🗂 Problems organized by **difficulty** and **patterns/topics**
* 🛠 Multi-language support (Python, C++, Java; feel free to add more)

---

## 🗂 Repo structure (suggested)

```
/leetcode-vault
├─ /easy
│  ├─ 1_two_sum/
│  │  ├─ solution.py
│  │  ├─ README.md       # short problem notes, approach, complexity
│  │  └─ tests.md        # sample inputs & expected outputs
├─ /medium
├─ /hard
├─ /patterns        # sliding-window, dp, greedy, graph, etc.
├─ /utils           # helpers, test harness, templates
├─ .github/
│  └─ workflows/    # CI (optional)
├─ CONTRIBUTING.md
├─ CODE_OF_CONDUCT.md
└─ README.md
```

---

## ✨ How to use

1. Browse by folder (difficulty or pattern) 📁
2. Open the problem folder → read the `README.md` for the approach 🧠
3. Run the `solution.*` file for the language of choice (examples below) ▶️

**Run examples (Python):**

```bash
python solution.py
# or
python -m pytest  # if you add tests
```

---

## 🧩 Problem folder template

When adding a solved problem, follow this template inside the problem folder:

```
/<problem_id>_<slug>/
├─ solution.py           # or solution.cpp / Solution.java
├─ README.md             # problem link, short approach, complexity
├─ tests.md              # small sample cases
└─ .gitignore            # optional
```

**README.md (problem) example:**

```md
# Two Sum — Problem 1
[LeetCode link](https://leetcode.com/problems/two-sum)

## Approach
- Use a hash map to store complement indices.
- Single pass — O(n) time, O(n) space.

## Complexity
- Time: O(n)
- Space: O(n)

## Example
Input: [2,7,11,15], target = 9
Output: [0,1]
```

---

## 🤝 Contribution Guide

* Fork → create a feature branch → open a PR
* Include:

  * Problem link
  * Short approach explanation (1–3 paragraphs)
  * Complexity analysis (Time & Space)
  * Minimal test cases
* Keep style consistent. Add unit tests where possible.
* Use descriptive commit messages: `feat: add 1_two_sum (python)`

**PR Checklist:**

* [ ] Solution file present and runnable
* [ ] `README.md` with explanation included
* [ ] Complexity stated
* [ ] Tests added (if possible)

---

## 🧭 Coding Style & Conventions

* Filename: `solution.<ext>`
* Use descriptive variable names and add comments for non-obvious steps
* Add `Time: O(...)` and `Space: O(...)` in the problem README
* Small, focused commits with clear messages

**Python tips:**

* Target Python 3.8+
* Add `if __name__ == "__main__":` block for quick manual tests

---

## 🧪 Testing & CI (optional)

* Add pytest or language-specific unit tests in a `tests/` folder
* Example GitHub Actions workflow: run tests for Python and linting on push/PR

---

## 🔧 Utilities & Helpers

Consider adding a `/utils` folder for:

* Input parsing helpers
* Test harness script to run multiple `solution.*` files
* Templates for new problem folders (script to scaffold)

---

## 🏷 Badges (suggested)

Add badges in the top of this README for quick status:

* `stars`, `license`, `build (CI)`, `tests` etc.

---

## 📌 License

Add a license (MIT recommended) to allow reuse:

```
MIT License
```

---

## 📈 Roadmap / TODOs

* [ ] Add CI to run tests automatically
* [ ] Add problem tagging by pattern (DP, graph, greedy)
* [ ] Add language-specific folders for major languages

---

## 📝 Quick Templates (to copy)

**Commit message:** `feat: add <id>_<slug> (<language>)`

**Problem README header:**

```
# <Title> — Problem <id>
[LeetCode link](<url>)
```

---

## ❤️ Credits

Made with ❤️ for learning and interview prep. Feel free to use, improve, and share.

---

*Happy coding & good luck with your repo!* ✨
