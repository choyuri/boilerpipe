
# Web wrapper for [Boilerpipe](https://code.google.com/p/boilerpipe/) 

  A very tiny appengine wrapper for boilerpipe api which extracts uncluttered text from html pages. Useful to extract articles and similar stuff from wiki pages, new sites etc. 
 
 
 Demo is available at [Historianapp](https://historianapp.appspot.com/boilerpipe)
 
 * url: https://historianapp.appspot.com/boilerpipe
 * method: POST
 * parameters:
  
   1. contenttype : 'url' or 'html'  
   2. content: url of web page with protocol or html text
   3. extractor: one of 'default', 'article','sentence','largest','canola'
   4. echohtmlcontent: 'true' or 'false'
   
* output format: JSON

### Examples

```
curl https://historianapp.appspot.com/boilerpipe  --data "extractor=canola&echohtmlcontent=true&contenttype=url&content=http%3A%2F%2Fen.wikipedia.org%2Fwiki%2FEnglish_language"



curl 'https://historianapp.appspot.com/boilerpipe'  --data $'extractor=canola&echohtmlcontent=false&content=%3Carticle+class%3D%22markdown-body+entry-content%22+itemprop%3D%22mainContentOfPage%22%3E%3Ch1%3E+%3Ca+name%3D%22user-content-web-wrapper-for-boilerpipe%22+class%3D%22anchor%22+href%3D%22%23web-wrapper-for-boilerpipe%22+aria-hidden%3D%22true%22%3E%3Cspan+class%3D%22octicon+octicon-link%22%3E%3C%2Fspan%3E%3C%2Fa%3EWeb+wrapper+for+%3Ca+href%3D%22https%3A%2F%2Fcode.google.com%2Fp%2Fboilerpipe%2F%22%3EBoilerpipe%3C%2Fa%3E+%3C%2Fh1%3E++%3Cp%3EA+very+tiny+appengine+wrapper+for+boilerpipe+api+which+extracts+uncluttered+text+from+html+pages.+Useful+to+extract+articles+and+similar+stuff+from+wiki+pages%2C+new+sites+etc.+%3C%2Fp%3E++%3Cp%3EDemo+is+available+at+%3Ca+href%3D%22https%3A%2F%2Fhistorianapp.appspot.com%2Fboilerpipe%22%3EHistorianapp%3C%2Fa%3E%3C%2Fp%3E++%3Cul+class%3D%22task-list%22%3E+%3Cli%3Eurl%3A+%3Ca+href%3D%22https%3A%2F%2Fhistorianapp.appspot.com%2Fboilerpipe%22%3Ehttps%3A%2F%2Fhistorianapp.appspot.com%2Fboilerpipe%3C%2Fa%3E+%3C%2Fli%3E+%3Cli%3Emethod%3A+POST%3C%2Fli%3E+%3Cli%3E+%3Cp%3Eparameters%3A%3C%2Fp%3E++%3Col+class%3D%22task-list%22%3E+%3Cli%3Econtenttype+%3A+\'url\'+or+\'html\'%3Cbr%3E+%3C%2Fli%3E+%3Cli%3Econtent%3A+url+of+web+page+with+protocol+or+html+text%3C%2Fli%3E+%3Cli%3Eextractor%3A+one+of+\'default\'%2C+\'article\'%2C\'sentence\'%2C\'largest\'%2C\'canola\'%3C%2Fli%3E+%3C%2Fol%3E+%3C%2Fli%3E+%3C%2Ful%3E%3Ch3%3E+%3Ca+name%3D%22user-content-examples%22+class%3D%22anchor%22+href%3D%22%23examples%22+aria-hidden%3D%22true%22%3E%3Cspan+class%3D%22octicon+octicon-link%22%3E%3C%2Fspan%3E%3C%2Fa%3EExamples%3C%2Fh3%3E++%3Cpre%3E%3Ccode%3Ecurl+https%3A%2F%2Fhistorianapp.appspot.com%2Fboilerpipe++--data+%22extractor%3Dcanola%26amp%3Bcontenttype%3Durl%26amp%3Bcontent%3Dhttp%253A%252F%252Fen.wikipedia.org%252Fwiki%252FEnglish_language%22+%3C%2Fcode%3E%3C%2Fpre%3E%3C%2Farticle%3E'
```
 
   
 
 
 
 ### License: [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0) 
