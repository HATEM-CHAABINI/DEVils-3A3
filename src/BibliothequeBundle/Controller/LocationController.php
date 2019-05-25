<?php

namespace BibliothequeBundle\Controller;

use AppBundle\Entity\User;
use BibliothequeBundle\Entity\Livre;
use CMEN\GoogleChartsBundle\GoogleCharts\Charts\PieChart;
use Symfony\Component\HttpFoundation\Request;

use BibliothequeBundle\Entity\Location;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\Response;


/**
 * Location controller.
 *
 * @Route("location")
 */
class LocationController extends Controller
{

    /**
     * @Route("/ValiderLocationAdmin", name="ValideLocationAdmin")
     * @Method({"GET"})
     */
    public function ValiderLocationAdminAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $em->getRepository('BibliothequeBundle:Location')->annulerlocationpasse();
        $p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';

        $User= $em->getRepository('AppBundle:User')->findAll();
        if(!(preg_match("/{$search}/i",$p))) {
//            if ($request->isMethod("post")) {
//
//            $User = $this->getDoctrine()->getRepository(Location::class)->Meslocations($this->get('security.token_storage')->getToken()->getUser()->getId());
//        }
        return $this->render('location/ValiderLocationAdmin.html.twig', array(
            'User' => $User,
        ));
    }}


    /**
     * @Route("/{id}/AnnulerAdmin", name="AnnulerAdmin")
     * @Method({"GET"})
     */
    public function AnnulerLocationAdminAction(Request $request,User $Userr)
    {        $em = $this->getDoctrine()->getManager();
//var_dump($Userr);
//        $p=$this->get('security.token_storage')->getToken()->getUser();
//        $search='anon.';
$locations=[];
$locations=$em->getRepository('BibliothequeBundle:Location')->LocationEnCoursParUSername($Userr->getUsername());
        $em = $this->getDoctrine()->getManager();
//        $User= $em->getRepository('AppBundle:User')->findAll();
//var_dump($locations);
            return $this->render('location/RetourLivreAdmin.html.twig'
                , array(
                'Location' => $locations,

            )
    );
        }

    /**
     * @Route("/{id}/AnnulerLocation", name="AnnulerLocation")
     * @Method({"GET"})
     */
    public function AnnulerLocationAction(Request $request,Location $location)
    {        $em = $this->getDoctrine()->getManager();

        $location->setEtat("Annuler");
        $location->getLivre()->setQuantite($location->getLivre()->getQuantite()+1);

        $em->persist($location);
        $em->flush();


        return $this->redirectToRoute('ValideLocationAdmin');

    }

    /**
     * @Route("/{id}/RendreLocation", name="RendreLocation")
     * @Method({"GET"})
     */
    public function RendreLocationAction(Request $request,Location $location)
    {
        if ($location->getEtat()=="Valider") {

            $em = $this->getDoctrine()->getManager();
            $location->setEtat("Rendu");
            $location->getLivre()->setQuantite($location->getLivre()->getQuantite() + 1);

            $em->persist($location);

            $em->flush();
        }
        return $this->redirectToRoute('ValideLocationAdmin');

    }


    /**
     * @Route("/{id}/ValiderAdmin", name="ValiderAdmin")
     * @Method({"GET"})
     */
    public function ValiderAction(Request $request,User $Userr)
    {
        $p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';
//        var_dump($Userr);
$prix=0;
        $locations=[];

        $location=null;
        $em = $this->getDoctrine()->getManager();
//        $User= $em->getRepository('AppBundle:User')->findAll();
        if(!(preg_match("/{$search}/i",$p))) {
//            if ($request->isMethod("post")) {
        $location=$em->getRepository('BibliothequeBundle:Location')->LocationEnCoursParUSername($Userr->getUsername());
//    var_dump($location);
        //                $User = $this->getDoctrine()->getRepository(Location::class)->Meslocations($this->get('security.token_storage')->getToken()->getUser()->getId());
//            }
            foreach ($location as $w){
                if( $w->getDateRetour()->format("Y-m-d")>=date("Y-m-d")){
                    var_dump($w);
                    array_push($locations,$w);
                    $w->setEtat('Valider');
                    $em->persist($w);


                }}
            foreach ($locations as $val) {

//            var_dump("AAAAAAAAAAAAAAAAA");
                $prix=$prix+$val->getLivre()->getPrix();

//            var_dump("BBBBBBBBBBBBBBBBBB");

            }
//            var_dump($prix);
            $em->flush();
            return $this->redirectToRoute('ValideLocationAdmin');

//            return $this->render('location/ValideLocationAdmin.html.twig', array(
//                'Locations' => $location,
//            ));
        }
    }

    /**
     * Finds and displays a location entity.
     *
     * @Route("/imprimer", name="locationaimprimer")
     * @Method("GET")
     */
    public function ImprimerAction(Request $request)
    {
        $p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';
        $prix=0;
        $location=[];

        $em = $this->getDoctrine()->getManager();
        $locations=[];
        if(!(preg_match("/{$search}/i",$p))) {

            $location = $this->getDoctrine()->getRepository(Location::class)->LocationEnCoursParUSername($this->get('security.token_storage')->getToken()->getUser()->getUsername());
        }
        foreach ($location as $w){
        if( $w->getDateRetour()->format("Y-m-d")>=date("Y-m-d")){
            array_push($locations,$w);

        }}
        foreach ($locations as $val) {

//            var_dump("AAAAAAAAAAAAAAAAA");
            $prix=$prix+$val->getLivre()->getPrix();

//            var_dump("BBBBBBBBBBBBBBBBBB");

        }
        var_dump($prix);

        $snappy = $this->get('knp_snappy.pdf');

        $html = $this->renderView('location/imprimer.html.twig', array(
            'location' => $locations,
            'prix' =>$prix,
        ));

        $filename = 'myFirstSnappyPDF';

        return new Response(
            $snappy->getOutputFromHtml($html),
            200,
            array(
                'Content-Type'          => 'application/pdf',
                'Content-Disposition'   => 'inline; filename="'.$filename.'.pdf"'
            )
        );

//        return $this->render
   }




    /**
     * @Route("/mesLocati", name="meslocatio")
     * @Method({"GET"})
     */
    public function meslocationssAction(Request $request)
    {
        $p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';

        $em = $this->getDoctrine()->getManager();
        $locations=null;
        if(!(preg_match("/{$search}/i",$p))) {

            $locations = $this->getDoctrine()->getRepository(Location::class)->Meslocations($this->get('security.token_storage')->getToken()->getUser()->getId());
        }
        return $this->render('location/meslocation.html.twig', array(
            'location' => $locations,
              ));
    }

    /**
     * Creates a new location entity.
     *
     * @Route("/stat", name="stat")
     * @Method({"GET", "POST"})
     */
    public function statAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();

        $best = $em->getRepository('BibliothequeBundle:Location')->getBestLocations();
        $k = [['Livre', 'Nombre de locations']];
        foreach ($best as $val) {
            $l = $em->getRepository('BibliothequeBundle:Livre')->find($val[2]);
            array_push($k, [$l->getTitre(), (int)$val[1]]);
        }
        $pieChart = new PieChart();
        $pieChart->getData()->setArrayToDataTable(
            $k
        );
        $pieChart->getOptions()->setTitle('Nos meilleurs locations');
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
        $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
        $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
        $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
        $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);

        return $this->render('location/Stat.html.twig', array(
            'piechart' => $pieChart,

        ));
    }



    /**
     * Lists all location entities.
     *
     * @Route("/", name="location_index")
     * @Method("GET")
     */
    public function indexAction(Request $request)
    {
        $p=$this->get('security.token_storage')->getToken()->getUser();
        $search='anon.';

        $em = $this->getDoctrine()->getManager();
        if ($request->isMethod("post")) {
            if(!(preg_match("/{$search}/i",$p))){

                $best = $em->getRepository('BibliothequeBundle:Location')->getBestLocations();
                $k = [['Livre', 'Nombre de locations']];
                foreach ($best as $val) {
                    $l = $em->getRepository('BibliothequeBundle:Livre')->find($val[2]);
                    array_push($k, [$l->getTitre(), (int)$val[1]]);
                }
                $pieChart = new PieChart();
                $pieChart->getData()->setArrayToDataTable(
                    $k
                );
                $pieChart->getOptions()->setTitle('Best livres locations');
                $pieChart->getOptions()->setHeight(500);
                $pieChart->getOptions()->setWidth(900);
                $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
                $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
                $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
                $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
                $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);

                $livress = $em->getRepository('BibliothequeBundle:Livre')->getLivresByTitreOrDesc($request->get('keyword'));
                $User = new User();
                $User->setPrenom(($this->get('security.token_storage')->getToken()->getUser()->getPrenom()));
                $locations = $this->getDoctrine()->getRepository(Location::class)->myfindAll($this->get('security.token_storage')->getToken()->getUser()->getId());
                $livres = $this->get('knp_paginator')->paginate($livress, $request->query->get('page', 1), 4);
                return $this->render('location/index.html.twig', array(
                    'locations' => $locations,
                    'locataire' => $User,
                    'livres' => $livres,
                    'piechart' => $pieChart

                ));}
            else{

                $best = $em->getRepository('BibliothequeBundle:Location')->getBestLocations();
                $k = [['Livre', 'Nombre de locations']];
                foreach ($best as $val) {
                    $l = $em->getRepository('BibliothequeBundle:Livre')->find($val[2]);
                    array_push($k, [$l->getTitre(), (int)$val[1]]);
                }
                $pieChart = new PieChart();
                $pieChart->getData()->setArrayToDataTable(
                    $k
                );
                $pieChart->getOptions()->setTitle('Best livres locations');
                $pieChart->getOptions()->setHeight(500);
                $pieChart->getOptions()->setWidth(900);
                $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
                $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
                $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
                $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
                $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);

                $livress = $em->getRepository('BibliothequeBundle:Livre')->getLivresByTitreOrDesc($request->get('keyword'));
                $User =null;
                // $User->setPrenom(($this->get('security.token_storage')->getToken()->getUser()->getPrenom()));
                $locations =null;
                //$this->getDoctrine()->getRepository(Location::class)->myfindAll($this->get('security.token_storage')->getToken()->getUser()->getId());
                $livres = $this->get('knp_paginator')->paginate($livress, $request->query->get('page', 1), 4);
                return $this->render('location/index.html.twig', array(
                    'locations' => $locations,
                    'locataire' => $User,
                    'livres' => $livres,
                    'piechart' => $pieChart

                ));


            }
        }


        $best = $em->getRepository('BibliothequeBundle:Location')->getBestLocations();
        $k = [['Livre', 'Nombre de locations']];
        foreach ($best as $val) {
            $l = $em->getRepository('BibliothequeBundle:Livre')->find($val[2]);
            array_push($k, [$l->getTitre(), (int)$val[1]]);
        }
        $pieChart = new PieChart();
        $pieChart->getData()->setArrayToDataTable(
            $k
        );
        $pieChart->getOptions()->setTitle('Best livres locations');
        $pieChart->getOptions()->setHeight(500);
        $pieChart->getOptions()->setWidth(900);
        $pieChart->getOptions()->getTitleTextStyle()->setBold(true);
        $pieChart->getOptions()->getTitleTextStyle()->setColor('#009900');
        $pieChart->getOptions()->getTitleTextStyle()->setItalic(true);
        $pieChart->getOptions()->getTitleTextStyle()->setFontName('Arial');
        $pieChart->getOptions()->getTitleTextStyle()->setFontSize(20);

        $User = new User();

        if(!(preg_match("/{$search}/i",$p))){
            $User->setPrenom(($this->get('security.token_storage')->getToken()->getUser()->getPrenom()));
            $locations = $this->getDoctrine()->getRepository(Location::class)->myfindAll($this->get('security.token_storage')->getToken()->getUser()->getId());
            $livress = $em->getRepository('BibliothequeBundle:Livre')->findAll();
            $livres = $this->get('knp_paginator')->paginate($livress, $request->query->get('page', 1), 4);
            return $this->render('location/index.html.twig', array(
                'locations' => $locations,
                'locataire' => $User,
                'livres' => $livres,
                'piechart' => $pieChart
            ));}
        else{
            $User=null;
            $locations = null;
            $livress = $em->getRepository('BibliothequeBundle:Livre')->findAll();
            $livres = $this->get('knp_paginator')->paginate($livress, $request->query->get('page', 1), 4);
            return $this->render('location/index.html.twig', array(
                'locations' => $locations,
                'locataire' => $User,
                'livres' => $livres,
                'piechart' => $pieChart
            ));
        }
    }
//        $locations = $this->getDoctrine()->getRepository(Location::class)->myfindAll( $this->get('security.token_storage')->getToken()->getUser()->getId());

//        var_dump( $this->get('security.token_storage')->getToken()->getUser()->getId());
//        $em = $this->getDoctrine()->getManager();
//        $User=new User();
//        $User->setPrenom(($this->get('security.token_storage')->getToken()->getUser()->getPrenom()));
//        $locations = $em->getRepository('BibliothequeBundle:Location')->findAll();
//        $livres  = $em->getRepository('BibliothequeBundle:Livre')->findAll();
//        return $this->render('location/index.html.twig', array(
//            'locations' => $locations,
//            'locataire'=> $User,
//            'livres' => $livres
//        ));}



    /**
     * Creates a new location entity.
     *
     * @Route("/new", name="location_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $location = new Location();
        $livre = new Livre();
        $form = $this->createForm('BibliothequeBundle\Form\LocationType', $location);
        $form->handleRequest($request);
        //$Livre=$this->getDoctrine()->getRepository()->findAll();
        if ($form->isSubmitted() && $form->isValid()) {
            $location->setLocataire($user = $this->get('security.token_storage')->getToken()->getUser());
            $em = $this->getDoctrine()->getManager();
            $em->persist($location);
            $em->flush();

            return $this->redirectToRoute('location_show', array('id' => $location->getId()));
        }

        return $this->render('location/new.html.twig', array(
            'location' => $location,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a location entity.
     *
     * @Route("/{id}", name="location_show")
     * @Method("GET")
     */
    public function showAction(Location $location)
    {
        $deleteForm = $this->createDeleteForm($location);

        return $this->render('location/show.html.twig', array(
            'location' => $location,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing location entity.
     *
     * @Route("/{id}/edit", name="location_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, Location $location)
    {
        $deleteForm = $this->createDeleteForm($location);
        $editForm = $this->createForm('BibliothequeBundle\Form\LocationType', $location);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('location_edit', array('id' => $location->getId()));
        }

        return $this->render('location/edit.html.twig', array(
            'location' => $location,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }





    /**
     * Displays a form to edit an existing location entity.
     *
     * @Route("/{id}/rendue", name="location_rendue")
     * @Method({"GET", "POST"})
     */
    public function rendueAction(Request $request, Location $location)
    {

        $locations = $this->getDoctrine()->getRepository(Location::class)->rendue($location);
        return $this->redirectToRoute('location_index');

    }

    /**
     * Deletes a location entity.
     *
     * @Route("/{id}", name="location_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, Location $location)
    {
        $form = $this->createDeleteForm($location);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($location);
            $em->flush();
        }

        return $this->redirectToRoute('location_index');
    }


    public function louerAction(Request $request, $idlivre)
    {


        return $this->redirectToRoute('location_index');

    }


    /**
     * Creates a form to delete a location entity.
     *
     * @param Location $location The location entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Location $location)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('location_delete', array('id' => $location->getId())))
            ->setMethod('DELETE')
            ->getForm();
    }
}
