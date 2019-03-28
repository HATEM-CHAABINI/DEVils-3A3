<?php

namespace BibliothequeBundle\Controller;

use BibliothequeBundle\Entity\Bibliotheque;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;use Symfony\Component\HttpFoundation\Request;

/**
 * Bibliotheque controller.
 *
 * @Route("bibliotheque")
 */
class BibliothequeController extends Controller
{
    /**
     * Lists all bibliotheque entities.
     *
     * @Route("/", name="bibliotheque_index")
     * @Method("GET")
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $bibliotheques = $em->getRepository('BibliothequeBundle:Bibliotheque')->findAll();

        return $this->render('bibliotheque/index.html.twig', array(
            'bibliotheques' => $bibliotheques,
        ));
    }

    /**
     * Creates a new bibliotheque entity.
     *
     * @Route("/new", name="bibliotheque_new")
     * @Method({"GET", "POST"})
     */
    public function newAction(Request $request)
    {
        $bibliotheque = new Bibliotheque();
        $form = $this->createForm('BibliothequeBundle\Form\BibliothequeType', $bibliotheque);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($bibliotheque);
            $em->flush();

            return $this->redirectToRoute('bibliotheque_show', array('id' => $bibliotheque->getId()));
        }

        return $this->render('bibliotheque/new.html.twig', array(
            'bibliotheque' => $bibliotheque,
            'form' => $form->createView(),
        ));
    }

    /**
     * Finds and displays a bibliotheque entity.
     *
     * @Route("/{id}", name="bibliotheque_show")
     * @Method("GET")
     */
    public function showAction(Bibliotheque $bibliotheque)
    {
        $deleteForm = $this->createDeleteForm($bibliotheque);

        return $this->render('bibliotheque/show.html.twig', array(
            'bibliotheque' => $bibliotheque,
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Displays a form to edit an existing bibliotheque entity.
     *
     * @Route("/{id}/edit", name="bibliotheque_edit")
     * @Method({"GET", "POST"})
     */
    public function editAction(Request $request, Bibliotheque $bibliotheque)
    {
        $deleteForm = $this->createDeleteForm($bibliotheque);
        $editForm = $this->createForm('BibliothequeBundle\Form\BibliothequeType', $bibliotheque);
        $editForm->handleRequest($request);

        if ($editForm->isSubmitted() && $editForm->isValid()) {
            $this->getDoctrine()->getManager()->flush();

            return $this->redirectToRoute('bibliotheque_edit', array('id' => $bibliotheque->getId()));
        }

        return $this->render('bibliotheque/edit.html.twig', array(
            'bibliotheque' => $bibliotheque,
            'edit_form' => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
     * Deletes a bibliotheque entity.
     *
     * @Route("/{id}", name="bibliotheque_delete")
     * @Method("DELETE")
     */
    public function deleteAction(Request $request, Bibliotheque $bibliotheque)
    {
        $form = $this->createDeleteForm($bibliotheque);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->remove($bibliotheque);
            $em->flush();
        }

        return $this->redirectToRoute('bibliotheque_index');
    }

    /**
     * Creates a form to delete a bibliotheque entity.
     *
     * @param Bibliotheque $bibliotheque The bibliotheque entity
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm(Bibliotheque $bibliotheque)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('bibliotheque_delete', array('id' => $bibliotheque->getId())))
            ->setMethod('DELETE')
            ->getForm()
        ;
    }
}
