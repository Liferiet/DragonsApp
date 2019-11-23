<%@ tag body-content="scriptless" %>
<%@ attribute name="dragonName" required="true" type="java.lang.String" %>
<%@ attribute name="strength" required="true" type="java.lang.String" %>
<%@ attribute name="agility" required="true" type="java.lang.String" %>
<%@ attribute name="intelligence" required="true" type="java.lang.String" %>
<%@ attribute name="vitality" required="true" type="java.lang.String" %>


<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="row d-flex">
                <div class="p-2 mr-auto">${dragonName}</div>
                <div class="p-2">lv.20</div>
            </div>
            <div class="row p-2">
                <div class="col" >
                    <div class="row">
                        Strength = ${strength}
                    </div>
                    <div class="row">
                        Agility = ${agility}
                    </div>
                </div>
                <div class="col">
                    <div class="row">
                        Intelligence = ${intelligence}
                    </div>
                    <div class="row">
                        Vitality = ${vitality}
                    </div>
                </div>

            </div>
        </div>
        <div class="col p-2">Dragon image</div>
    </div>
</div>