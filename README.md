
# Web wrapper for [Boilerpipe](https://code.google.com/p/boilerpipe/) 

  A very tiny appengine wrapper for boilerpipe api which extracts uncluttered text from html pages. Useful to extract articles and similar stuff from wiki pages, new sites etc. 
 
 
 Demo is available at [Historianapp](https://historianapp.appspot.com/boilerpipe)
 
 * url: https://historianapp.appspot.com/boilerpipe
 * method: POST
 * parameters:
  
   1. contenttype : 'url' or 'html'  
   2. content: url of web page with protocol or html text
   3. extractor: one of 'default', 'article','sentence','largest','canola'
   

### Examples

```
curl https://historianapp.appspot.com/boilerpipe  --data "extractor=canola&contenttype=url&content=http%3A%2F%2Fen.wikipedia.org%2Fwiki%2FEnglish_language"
```
 
   
 
 
 
 
