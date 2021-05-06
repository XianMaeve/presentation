let deleteButtons = document.getElementsByClassName("delete");
let addButtons = document.getElementsByClassName("add");

for (let i = 0; i < deleteButtons.length; i++) {
    deleteButtons[i].addEventListener("click", function () {

        document.getElementsByClassName("submit").item(i).submit();


    });
}

// for (let k = 0; k <addButtons.length; k++) {
//     addButtons[i].addEventListener("click", function (){
//
//
//
//
//
//
//
//     })
// }




let addShoes = document.getElementById("addShoes");

if (addShoes != null) {
    addShoes.addEventListener("click", function () {


        document.getElementById("addShoesForm").innerHTML = `

<div class="addNewShoes">
    <form action="/addShoes/submit">
    
   
    <h1>What brand of shoes?</h1> <input type="text" name="shoeMake" value="shoeMake"><br>
    <h1>What model is your shoe?</h1> <input type="text" name="shoeModel" value="shoeModel"><br>
    <h1>What color is your shoe?</h1> <input type="text" name="color" value="color"><br>
    <h1>What size is your shoe?</h1> <input type="text" name="size" value="size"><br>
    <h1>Provide a photo of your image (URL)</h1> <input type="text" name="shoeImg" value="shoeImg"><br>
    <h1>In what type of conditions would you wear this shoe?</h1> <input type="text" name="weather" value="weather">
    
    <input type="submit">
    
    
</form>


</div>
`;

    })
}
;
let addAccessories = document.getElementById("addAccessories");

if (addAccessories != null) {
    addAccessories.addEventListener("click", function () {


        document.getElementById("addAccessoriesForm").innerHTML = `
<div class="addNewAccessories">
    <form action="addAccessories/submit">
    
    <h1>What type of Accessory?</h1> <input type="text" name="accessoryType"><br>
        <h1>What color is your Accessory??</h1> <input type="text" name="accessoryColor" ><br>
        <h1>Provide a photo of your Accessory (URL)</h1> <input type="text" name="accessoryImg" ><br>
        <h1>In what type of conditions would you wear this Accessory?</h1> <input type="text" name="weather" >
    
    <input type="submit">
    
    </form>
    `


    });
}


let addTops = document.getElementById("addTops");

if (addTops != null) {

    addTops.addEventListener("click", function () {


        document.getElementById("addTopsForm").innerHTML = `
<div class="addNewTops">
    <form action="/addTops/submit">
    
    <h1>Name of your Top?</h1> <input type="text" name="topType"><br>
        <h1>What color is your Top?</h1> <input type="text" name="color" ><br>
        <h1>What size is your Top?</h1> <input type="text" name="size"><br>
        <h1>Provide a photo of your Top (URL)</h1> <input type="text" name="topImg" ><br>
        <h1>In what type of conditions would you wear this Top?</h1> <input type="text" name="weather" >
    
    <input type="submit">
    
    </form>
        
        
     `


    });
}
let addJackets = document.getElementById("addJacket");

if (addJackets != null) {
    addJackets.addEventListener("click", function () {


        document.getElementById("addJacketForm").innerHTML = `
<div class="addNewJacket">
    <form action="/addJackets/submit">
    
    <h1>Name of your Jacket?</h1> <input type="text" name="jacketType"><br>
        <h1>What color is your Jacket?</h1> <input type="text" name="color" ><br>
        <h1>What size is your Jacket?</h1> <input type="text" name="size"><br>
        <h1>Provide a photo of your Jacket (URL)</h1> <input type="text" name="jacketImg" ><br>
        <h1>In what type of conditions would you wear this Jacket?</h1> <input type="text" name="weather" >
    
    <input type="submit">
    
    </form>
        
        
     `


    });
}

    let addBottoms = document.getElementById("addBottoms");
    if (addBottoms != null) {
        addBottoms.addEventListener("click", function () {

            document.getElementById("addBottomsForm").innerHTML = `
            
            
            
            <div class="addNewBottoms">
    <form action="addBottoms/submit">
    
    <h1>Name of your Bottoms?</h1> <input type="text" name="bottomType"><br>
        <h1>What color are your Bottoms?</h1> <input type="text" name="color" ><br>
        <h1>What size are your Bottoms?</h1> <input type="text" name="size"><br>
        <h1>Provide a photo of your Jacket (URL)</h1> <input type="text" name="bottomImg" ><br>
        <h1>In what type of conditions would you wear these Bottoms?</h1> <input type="text" name="weather" >
    
    <input type="submit">
    
    </form>
        
            
            
            
            
            
            `




        });


}

    let addOutfit = document.getElementById("addOutfit");
    if (addOutfit != null) {
        addOutfit.addEventListener("click", function () {



            location.href = "/create-outfit";



        });
    }