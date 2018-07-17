using System;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using System.Web.Mvc;
using RestSharp.Extensions;

namespace SampleWebApp.Controllers
{
    public class UploadController : ApiController
    {
        [System.Web.Mvc.HttpPost]
        public async Task<ActionResult> Index()
        {
            try
            {
                var provider = await Request.Content.ReadAsMultipartAsync();
            
                foreach (var httpContent in provider.Contents)
                {
                    var fileName = httpContent.Headers.ContentDisposition.FileName;
                    var escaped = fileName.Replace("\"", "");
                    
                    if (string.IsNullOrWhiteSpace(fileName))
                    {
                        continue;
                    }

                    using (var fileContents = await httpContent.ReadAsStreamAsync())
                    {
                        var path = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, escaped);
                        File.WriteAllBytes(path, fileContents.ReadAsBytes());
                    }
                }
                return new HttpStatusCodeResult(HttpStatusCode.OK);
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
        }
    }
}