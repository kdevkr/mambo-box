## 자바스크립트에서 파일 다운로드 받기

### Document Object Model
웹 브라우저에서 실행되는 자바스크립트에서는 임시 DOM 엘리먼트를 생성하고 클릭 이벤트를 호출하여 다운로드

```js
const link = document.createElement('a')
link.href = $url
link.click()
link.remove()
```

### Blob
웹 브라우저에서 Blob 객체를 지원한다면 Blob 객체를 통해 파일을 다운로드
> https://developer.mozilla.org/en-US/docs/Web/API/Blob

_**(Optional) Polyfill for IE 9**_
Blob 객체는 IE 10부터 지원하므로 IE 9에서 사용하기 위해서는 [Blob Polyfill](https://github.com/bjornstar/blob-polyfill)을 적용함.

#### window.URL

- ContentDisposition
- window.URL.createObjectURL
- window.URL.revokeObjectURL

```js
import ContentDisposition from 'content-disposition'

window.$download = function(url, params) {
    $axios({
        url: url,
        params: params,
        responseType: 'blob'
    }).then(res => {
        const contentDisposition = ContentDisposition.parse(res.headers['content-disposition'])
        const link = document.createElement('a');
        const blobUrl = window.URL.createObjectURL(new Blob([res.data]));
        link.href = blobUrl
        link.setAttribute('download', contentDisposition.parameters.filename);
        link.target = '_blank'
        link.click();
        link.remove()
        window.URL.revokeObjectURL(blobUrl);
    })
};
```

### FileSaver.js
`content-disposition`와 함께 [FileSaver.saveAs](https://github.com/eligrey/FileSaver.js/)으로도 Blob 데이터를 파일로 다운로드 가능

```js
import ContentDisposition from 'content-disposition'
import { saveAs } from 'file-saver'

$axios({
    url: url,
    params: params,
    responseType: 'blob'
}).then(res => {
    const contentDisposition = ContentDisposition.parse(res.headers['content-disposition'])
    const blob = new Blob([res.data])

    saveAs(blob, contentDisposition.parameters.filename)
})
```

## 참고
- [Download files with AJAX (axios)](https://gist.github.com/javilobo8/097c30a233786be52070986d8cdb1743)
- [FileSaver.js](https://github.com/eligrey/FileSaver.js/)
- [Blob Polyfill](https://github.com/bjornstar/blob-polyfill)
